@Override 
public Map<String, String> getHeaders() throws AuthFailureError { 
    Map<String, String> params = new HashMap<String, String>();                
    params.put("Content-Type", "application/json");
    return params; 
}