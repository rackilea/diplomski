if (ServletFileUpload.isMultipartContent(request)) {
    // Parse with FileUpload.
}
else {
    // Use normal getParameter().
}