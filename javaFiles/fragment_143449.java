if (item.isFormField()) {
    // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
    String fieldname = item.getFieldName();
    String fieldvalue = item.getString();
    // ... (do your regular form field processing job here)
} else {
    // Process form file field (input type="file").
    String fieldname = item.getFieldName();
    String filename = FilenameUtils.getName(item.getName());
    // ... (do your uploaded file job here)
    File file = new File("D:/MyUploads/", filename);
    item.write(file);
}