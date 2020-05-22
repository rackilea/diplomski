JSONObject outer = new JSONObject();
        try {
            // field
            outer.put("EMAIL", reqModel.getEmail());
            // field
            outer.put("PASSWORD", reqModel.getPassword());
        } catch (JSONException e) {
            //
        } catch (Exception e) {
            //
        }
        return outer.toString();