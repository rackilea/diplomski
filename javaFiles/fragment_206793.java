if (request.getRemoteUser() != null) {
    // Already logged in, so redirect to some main page.
    response.sendRedirect(request.getContextPath() + "/main");
    return;
}

// ...