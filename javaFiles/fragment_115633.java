protected Map<String, String> getParams() throws AuthFailureError {
  Map<String, String> params = new HashMap<>();
  params.put("username", username);
  params.put("password", password);
  params.put("type", type);
  return  params;
}```