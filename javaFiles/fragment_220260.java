JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(...your arguments here) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> headerParameters = new HashMap<>();
                    headerParameters.put("Accept", "application/json");
                    headerParameters.put("Content-Type", "application/json");
                    return headerParameters;
                }
            };