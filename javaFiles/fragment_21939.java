public void doPost(HttpServletRequest request, HttpServletResponse response) 
                                      throws ServletException, IOException {    
    StringBuffer jb = new StringBuffer();
    String line = null;
    try {
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            jb.append(line);
        }
    } catch (Exception e) { /*report an error*/ }

    try {
        JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());
        String price = jsonObject.get("price"); // will return price value.
    } catch (JSONException e) {
        throw new IOException("Error parsing JSON request string");
    }
}