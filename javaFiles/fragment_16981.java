public void doGet(HttpServletRequest req, HttpServletResponse res){
  try {
    String action = req.getParameter(Constants.ACTION);
    if(action.equals("add")){
      Text description = new Text(req.getParameter("description")); 
    }
  } catch (Exception e) {
  }
}