package com.bullethq.jawr.postprocessor;

import net.jawr.web.resource.FileNameUtils;
import net.jawr.web.resource.bundle.factory.util.PathNormalizer;
import net.jawr.web.resource.bundle.postprocess.BundleProcessingStatus;
import net.jawr.web.resource.bundle.postprocess.impl.CSSURLPathRewriterPostProcessor;
import net.jawr.web.resource.bundle.postprocess.impl.PostProcessorCssImageUrlRewriter;

import java.io.IOException;

public class CustomCssUrlPathRewriterPostProcessor extends CSSURLPathRewriterPostProcessor {

    public static final String CUSTOM_URL_PATH_REWRITER = "customcsspathrewriter";

    public CustomCssUrlPathRewriterPostProcessor() {
        super(CUSTOM_URL_PATH_REWRITER);
    }

    // ========================================================================
    // ========================================================================
    // ========================================================================
    @Override
    protected PostProcessorCssImageUrlRewriter createImageUrlRewriter(BundleProcessingStatus status) {
        return new CustomPostProcessorCssImageUrlRewriter(status);
    }

    // ========================================================================
    // ========================================================================
    // ========================================================================
    public class CustomPostProcessorCssImageUrlRewriter extends PostProcessorCssImageUrlRewriter {

        public CustomPostProcessorCssImageUrlRewriter(BundleProcessingStatus status) {
            super(status);
        }

        // ========================================================================
        // ========================================================================
        // ========================================================================
        @Override
        protected String getUrlPath(String match, String originalPath, String newCssPath) throws IOException {
            String url = match.substring(match.indexOf('(') + 1, match.lastIndexOf(')')).trim();

            // Remove any quotes if necessary.
            String quoteStr = "";
            if (url.startsWith("'") || url.startsWith("\"")) {
                quoteStr = String.valueOf(url.charAt(0));
                url = url.substring(1, url.length() - 1);
            }

            // We now check if the url ends in a known image file extension
            // If not, the url is ignored.
            if (FileNameUtils.hasImageExtension(url)) {
                return super.getUrlPath(match, originalPath, newCssPath);
            } else {
                // We need to rewrite the path, as any relative URLs will
                // not resolve correctly if Jawr has changed the CSS path.
                url = PathNormalizer.concatWebPath(originalPath, url);
                url = PathNormalizer.getRelativeWebPath(PathNormalizer.getParentPath(newCssPath), url);
                return "url(" + quoteStr + url + quoteStr + ")";
            }
        }
    }
}