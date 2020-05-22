Bean bean = (Bean) pageContext.getAttribute("bean", PageContext.REQUEST_SCOPE);

if (bean == null) {
    bean = new Bean();
    pageContext.setAttribute("bean", bean, PageContext.REQUEST_SCOPE);
}

// Use bean ...