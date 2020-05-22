public void search(ActionRequest request, ActionResponse response) {
   try {
      authorName = ParamUtil.getString(request, "authorName");
      content = ParamUtil.getString(request, "content");

      request.setAttribute("authorName", authorName);
      request.setAttribute("content", content);
   } catch (Exception e) {
      // you always want to at least log an exception, even if you plan on ignoring.
   }
}