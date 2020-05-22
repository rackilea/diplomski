private JSONObject processInheritance(JSONObject template) throws AssetLoadingException {
        try {
            if (!template.has("extends")) {
                return template;
            } else {
                //Everything else
            }
        } catch (JSONException ex) {
            throw new AssetLoadingException(ex);
        }
    }