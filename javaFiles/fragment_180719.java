public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String keyword = request.getParameter("keyword");
    if (keyword != null) {
        if (!StringUtils.hasLength(keyword)) {
            return new ModelAndView("Error", "message", "Please enter a keyword to search for, then press the search button.");
        }
        PagedListHolder productList = new PagedListHolder(this.petStore.searchProductList(keyword.toLowerCase()));
        productList.setPageSize(4);
        request.getSession().setAttribute("SearchProductsController_productList", productList);
        return new ModelAndView("SearchProducts", "productList", productList);
    }
    else {
        String page = request.getParameter("page");
        PagedListHolder productList = (PagedListHolder) request.getSession().getAttribute("SearchProductsController_productList");
        if (productList == null) {
            return new ModelAndView("Error", "message", "Your session has timed out. Please start over again.");
        }
        if ("next".equals(page)) {
            productList.nextPage();
        }
        else if ("previous".equals(page)) {
            productList.previousPage();
        }
        return new ModelAndView("SearchProducts", "productList", productList);
    }
}