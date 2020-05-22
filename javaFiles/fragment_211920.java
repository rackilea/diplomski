protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

   MouseInput oneInput = getMouseInput(); //abstracted (I'm using google appengine)
   byte[] inputInBytes = oneInput.getInBytes();
   OutputStream o = resp.getOutputStream();
   o.write(inputInBytes);
   o.flush();
   o.close();
}