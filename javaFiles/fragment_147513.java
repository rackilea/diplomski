protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    if (!response.isCommitted()) {
        response.sendError(
            HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
            "Error message");
    }
//...
}