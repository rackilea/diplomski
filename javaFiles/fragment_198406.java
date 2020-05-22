public boolean isValidJson(String json) {
    try {
        // parse json
        return true;
    } catch(MalformedJsonException e) {
        return false;
    }
}