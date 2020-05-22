JSONArray jArray = new JSONArray(response);

        if (jArray != null) {

            for (int i = 0; i < jArray.length(); i++) {
                try {

                    searchResult = new ArrayList<Message>();