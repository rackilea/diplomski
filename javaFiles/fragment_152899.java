Function<Response, List<T>> resultFromResponse = 
    new Function<Response /* 1st parameter type */, Result /* return type */>() {
        @Override
        public Result apply(Response response) {
            // example: read some json from the response
            String message = response.asJson().get("message");
            Result result = ok(message);
            return result;
        }
    };