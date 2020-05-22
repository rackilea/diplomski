public RegisterRequest(String name, String username, int age, String password, Response.Listener<String> listener) throws AuthFailureError {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);
        params.put("age", age+ "");
}