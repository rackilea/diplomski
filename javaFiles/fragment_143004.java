JSONObject json1 = new JSONObject();
json1.put("Info", jarr);

response.setContentType("application/json");
response.setCharacterEncoding("UTF-8");

response.getWriter().write(json1.toString());
rs.close();