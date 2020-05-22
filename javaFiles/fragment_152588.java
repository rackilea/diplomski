String jsonString = "{\"Result\":true,\"Messages\":[\"Goe bezig!\"]}";

    JSONObject jsonObject = new JSONObject(jsonString);

    boolean result = (Boolean) jsonObject.get("Result");

    System.out.println(result);