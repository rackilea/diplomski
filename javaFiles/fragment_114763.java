package com.test;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;    
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;    
import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;
import org.apache.taglibs.standard.tag.el.core.UrlTag;

public class CustomUrlTag extends UrlTag {

    private static final long serialVersionUID = 1L;    
    private String includeAllParams;    
    private String excludeParams;

    public CustomUrlTag() {
        init();
    }

    @Override
    public int doStartTag() throws JspException {
        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {

        if (isIncludeAllParam()) {

          final HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();

          // iterate over request parameters
          final List<String> requestParameterNames = Collections.list((Enumeration<String>) request.getParameterNames());

          // exclude parameters
          if (null != excludeParams) {
              for (final String currentExcludeParam : excludeParams.split("[,]")) {
                  requestParameterNames.remove(currentExcludeParam);
              }
          }

          for (final String parameterName : requestParameterNames) {
              // add parameters
              addParameter(parameterName, request.getParameter(parameterName));
          }
        }
        return super.doEndTag();
    }

    @Override
    public void release() {
        super.release();
        init();
    }

    private void init() {
        includeAllParams = null;
    }

    private boolean isIncludeAllParam() throws JspException {
        final Object r = ExpressionEvaluatorManager.evaluate("includeAllParams", includeAllParams,
                java.lang.Boolean.class, this, pageContext);
        if (r != null) {
            return ((Boolean) r).booleanValue();
        }
        return false;
    }

    public void setIncludeAllParams(String includeAllParams) {
        this.includeAllParams = includeAllParams;
    }

    public void setExcludeParams(String excludeParams) {
        this.excludeParams = excludeParams;
    }
}