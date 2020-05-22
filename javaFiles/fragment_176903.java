protected void doPost(HttpServletRequest request, 
        HttpServletResponse response) throws ServletException, IOException {

JSONObject json = null;
PrintWriter pw = response.getWriter(); 

try {
    json = new JSONObject();
    json.put("key1", "value1");
    json.put("key2", "value2");
    json.put("key3", "value3");
} catch (JSONException e) {
    e.printStackTrace();
}
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json.toString());
    response.flushBuffer();  //flush the written json string 
    pw.close(); 
}