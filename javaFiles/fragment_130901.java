JsonSurfer surfer = JsonSurfer.jackson();
Builder builder = config();
builder.bind("$.items[*]", new JsonPathListener() {
        @Override
        public void onValue(Object value, ParsingContext context) throws Exception {
            // handle the value
        }
    });
surfer.surf(new InputStreamReader(response.getBody()), builder.build());