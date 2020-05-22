if (delegate != null) {
            T body = delegate.extractData(response);
            return new ResponseEntity<T>(body, response.getHeaders(), response.getStatusCode());
        }
        else {
            return new ResponseEntity<T>(response.getHeaders(), response.getStatusCode());
        }