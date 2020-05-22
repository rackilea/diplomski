if (new File(destination).listFiles().length <= 1) {
    return "/GUI/printServerSide.xhtml";
}
else if("txt".equalsIgnoreCase(extension)) {
    return "/GUI/submittedFilePreview.xhtml";
}
else if ("jpeg".equalsIgnoreCase(extension)) {
    return "/GUI/submittedFilePreview.xhtml";
}
else if ("jpg".equalsIgnoreCase(extension)) {
    return "/GUI/submittedFilePreview.xhtml";
}
else if ("png".equalsIgnoreCase(extension)) {
    return "/GUI/submittedFilePreview.xhtml";
}
else if ("gif".equalsIgnoreCase(extension)) {
    return "/GUI/submittedFilePreview.xhtml";
}
else if ("pdf".equalsIgnoreCase(extension)) {
    return "/GUI/submittedFilePreview.xhtml";
}
else if ("html".equalsIgnoreCase(extension)) {
    return "/GUI/submittedFilePreview.xhtml";
}
else {
    return "/GUI/printServerSide.xhtml";
}