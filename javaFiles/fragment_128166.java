public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 response.setContentType("text/html");
 PrintWriter pw = response.getWriter();
 String emp = request.getParameter("emp") != null ? request.getParameter("emp") : "";
 MCenter mCenter = new MCenter();
 mCenter = mCenterDAO.getMCenterPocByEmp(emp);
 mCenter = mCenterDAO.getMCenterByObject(mCenter);
 String mPocName = mCenter.getMCenterPocName();
 String mCenter = mCenter.getMCenterName();
 if (mPocName == null || mCenter == null) {
  String json = "error";
 } else {
  String json = getMCenterPoc(emp);
 }
 pw.print(json);
 pw.close();
}