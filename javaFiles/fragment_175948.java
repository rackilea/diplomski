try {
    chain.doFilter(request, response);
} catch (ServletException e) {
    if (e.getRootCause() instanceof ViewExpiredException) {
        request.getRequestDispatcher("/expired").forward(request, response);
    } else {
        throw e;
    }
}