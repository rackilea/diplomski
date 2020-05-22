package org.my.example.tags;

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.tags.form.FormTag;
import org.springframework.web.servlet.tags.form.TagWriter;

/**
 */
public class SpringFormTag extends FormTag {
    private static final String FOCUS_ATTRIBUTE = "focus";
    private String focus;

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getFocus() {
        return focus;
    }

    @Override
    protected void writeDefaultAttributes(TagWriter tagWriter) throws JspException {
        writeOptionalAttribute(tagWriter, FOCUS_ATTRIBUTE, getFocus());
        super.writeDefaultAttributes(tagWriter);
    }
}