try {
    writer.write(someHtml);
} catch (SomeException e) {
    writer.write("<script>window.location = 'error.jsp';</script>");
    // ...
}