public String getIndex() {
   int numItemsPerPage = 100;
   int page = Integer.parseInt(getPageContext().getRequest().getParameter("page"));
   int index = getListIndex();

   return ((page - 1) * numItemsPerPage) + index + 1;
}