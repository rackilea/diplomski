JSONArray jArray = new JSONArray(response);

        if (jArray != null) {
            searchResult = new ArrayList<Message>();

            for (int i = 0; i < jArray.length(); i++) {
                try {