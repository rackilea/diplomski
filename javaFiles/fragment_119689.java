String json = "{\"def\":[\n" +
                "  {\n" +
                "    \"sseq\":[\n" +
                "      [\n" +
                "        [\n" +
                "          \"sense\",\n" +
                "          {\n" +
                "            \"dt\":[[\"text\",\"{bc}a {a_link|backward} somersault especially\n" +
                "              in the air\"]]\n" +
                "          }\n" +
                "        ]\n" +
                "      ]\n" +
                "    ]\n" +
                "  }\n" +
                "]}";

        try {
            JSONObject jsonObject = new JSONObject(json);
            String dt = jsonObject.getJSONArray("def")
                    .getJSONObject(0)
                    .getJSONArray("sseq")
                    .getJSONArray(0)
                    .getJSONArray(0)
                    .getJSONObject(1)
                    .getJSONArray("dt")
                    .getJSONArray(0)
                    .getString(1);
            Log.i("jsondata", dt);
        } catch (JSONException e) {
            e.printStackTrace();
        }