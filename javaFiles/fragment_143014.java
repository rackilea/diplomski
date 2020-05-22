package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Applies search and replace patterns. To initialize this filter, the
 * param-names should be "search1", "replace1", "search2", "replace2", etc.
 */
public final class RegexFilter implements Filter {
    private List<Pattern> searchPatterns;
    private List<String> replaceStrings;

    /**
     * Finds the search and replace strings in the configuration file. Looks for
     * matching searchX and replaceX parameters.
     */
    public void init(FilterConfig filterConfig) {
        Map<String, String> patternMap = new HashMap<String, String>();

        // Walk through the parameters to find those whose names start with
        // search
        Enumeration<String> names = (Enumeration<String>) filterConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            if (name.startsWith("search")) {
                patternMap.put(name.substring(6), filterConfig.getInitParameter(name));
            }
        }
        this.searchPatterns = new ArrayList<Pattern>(patternMap.size());
        this.replaceStrings = new ArrayList<String>(patternMap.size());

        // Walk through the parameters again to find the matching replace params
        names = (Enumeration<String>) filterConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            if (name.startsWith("replace")) {
                String searchString = patternMap.get(name.substring(7));
                if (searchString != null) {
                    this.searchPatterns.add(Pattern.compile(searchString));
                    this.replaceStrings.add(filterConfig.getInitParameter(name));
                }
            }
        }
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Wrap the response in a wrapper so we can get at the text after calling the next filter
        PrintWriter out = response.getWriter();
        CharResponseWrapper wrapper = new CharResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request, wrapper);

        // Extract the text from the completed servlet and apply the regexes
        String modifiedHtml = wrapper.toString();
        for (int i = 0; i < this.searchPatterns.size(); i++) {
            modifiedHtml = this.searchPatterns.get(i).matcher(modifiedHtml).replaceAll(this.replaceStrings.get(i));
        }

        // Write our modified text to the real response
        response.setContentLength(modifiedHtml.getBytes().length);
        out.write(modifiedHtml);
        out.close();
    }

    public void destroy() {
        this.searchPatterns = null;
        this.replaceStrings = null;
    }
}