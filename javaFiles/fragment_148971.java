Bean bean = (Bean) pageContext.getAttribute("bean", PageContext.REQUEST_SCOPE);

if (bean == null) {
    throw new ServletException("bean not found within scope");
}

// Use bean ...