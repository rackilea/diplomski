Map<String, Object> data = new HashMap<String, Object>();
data.put("result", "Upload successful!");
// ...
response.setContentType("application/json");
resposne.setCharacterEncoding("UTF-8");
resposne.getWriter().write(new Gson().toJson(data));