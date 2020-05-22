StringRequest request = new StringRequest(Request.Method.GET, urlRequest, future, future) {
    @Override
    protected VolleyError parseNetworkError(VolleyError volleyError) {
        if (volleyError != null && volloeyError.networkResponse != null) {
            int statusCode = volleyError.networkResponse.statusCode;
            switch (statusCode) {
                case 403:
                    // Forbidden
                    break;
                case 404:
                    // Page not found
                    break;
            }
        }
        return volleyError;
    }
};