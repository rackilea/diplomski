try {
        JSONObject json = new JSONObject(response);

        JSONArray itemArray = json.getJSONArray("chatCircles");
        for (int i = 0; i < itemArray.length(); i++) {
            JSONObject subJson = (JSONObject) itemArray.get(i);
            String id = subJson.getString("id");
            String name = subJson.getString("name");
            String description = subJson.getString("description");
            Log.i("TEST", "id=" + id + ", name=" + name + ", description=" + description);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }