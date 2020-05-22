package com.opencmsserver.taglib;

import org.opencms.flex.CmsFlexController;
import org.opencms.jsp.Messages;
import org.opencms.main.CmsLog;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.logging.Log;

/**
 * Removes the <p> tag from the surrounded content, 
 * because FCKEditor always add <p> tag to content at 
 * the beginning and end when using the html editor component  
 *
 * @author  Mathias Lin 
 * 
 * @version $Revision: 0.1 $ 
 * 
 * @since 0.4 
 */
public class StripPTag extends BodyTagSupport {

    /** Serial version UID required for safe serialization. */
    private static final long serialVersionUID = -2361021288258405388L;

    /** The log object for this class. */
    private static final Log LOG = CmsLog.getLog(StripPTag.class);


    /**
     * @see javax.servlet.jsp.tagext.Tag#doEndTag()
     * @return EVAL_PAGE
     * @throws JspException in case soemthing goes wrong
     */
    public int doEndTag() throws JspException {

        ServletRequest req = pageContext.getRequest();

        // This will always be true if the page is called through OpenCms 
        if (CmsFlexController.isCmsRequest(req)) {
            try {
                // Get link-string from the body and reset body 
                String content = getBodyContent().getString();
                content = content.replaceAll("<p>", "");
                content = content.replaceAll("</p>", "");
                getBodyContent().clear();
                getBodyContent().print(content);
                getBodyContent().writeOut(pageContext.getOut());

            } catch (Exception ex) {
                if (LOG.isErrorEnabled()) {
                    LOG.error("Failed using StripPTag. ", ex);
                }
                throw new JspException(ex);
            }
        }
        return EVAL_PAGE;
    }
}