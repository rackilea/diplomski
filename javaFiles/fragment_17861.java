if (item.isFormField()) {
    // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
    String fieldname = item.getFieldName();
    String fieldvalue = item.getString();

    BeanUtils.setProperty(dto, fieldname, fieldvalue);
}