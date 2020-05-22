JsonParser parser = new JsonParser("https://url", "GET", parameters);
parser.setListener(new JsonParser.ParserListener() {
      @Override
       public void onSuccess(JSONObject result) {
            /* delivered result */
        }

        @Override
        public void onFailure() {
                /* delivered failure */
        }
        });
parser.execute();