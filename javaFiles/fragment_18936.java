Gson gson = new Gson();
        String escaped = gson.toJson(value);
        if(value instanceof String) {

            if(escaped.startsWith("\"")) {
                escaped = escaped.substring(1);
            }
            if(escaped.endsWith("\"")) {
                escaped = escaped.substring(0, escaped.length() - 1);
            }
            return escaped;
        }
        value = escaped;