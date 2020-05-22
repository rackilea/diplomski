StringRequest request = new StringRequest(Request.Method.POST, "url",
            (response) -> {
                //Handle response
            },
            (error) -> {
                //Handle error
            }) {
        @Override
        protected Map<String, String> getParams() {
            Map<String, String> parmas = new HashMap<>();

            //here we pass params
            parmas.put("action","checkIn");

            return parmas;
        }
    };