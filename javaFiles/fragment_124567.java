public class NullOptionTag extends OptionTag {

  @Override
  protected void renderDefaultContent(TagWriter tagWriter) throws JspException {
    Object value = this.pageContext.getAttribute(VALUE_VARIABLE_NAME);
    renderOptionSpecialWay(value, "", tagWriter);
  }

  @Override
  protected void renderFromBodyContent(BodyContent bodyContent, TagWriter tagWriter) throws JspException {
   Object value = this.pageContext.getAttribute(VALUE_VARIABLE_NAME);
   String label = bodyContent.getString();
   renderOptionSpecialWay(value, label, tagWriter);
  }

  private void renderOptionSpecialWay(Object value, String label, TagWriter tagWriter) throws JspException {
    tagWriter.startTag("option");
    writeOptionalAttribute(tagWriter, "id", resolveId());
    writeOptionalAttributes(tagWriter);
    String renderedValue = getDisplayString(value, getBindStatus().getEditor());
    tagWriter.writeAttribute(OptionTag.VALUE_VARIABLE_NAME, renderedValue);
    if (isSelected(value)) {
        tagWriter.writeAttribute("selected", "selected");
    }
    if (isDisabled()) {
        tagWriter.writeAttribute("disabled", "disabled");
    }
    tagWriter.appendValue(label);
    tagWriter.endTag();
  }

  private boolean isSelected(Object resolvedValue) {
    BindStatus bindStatus = getBindStatus();      
    return bindStatus == null || bindStatus.getValue() == null || bindStatus.getActualValue() == null;
  }
}