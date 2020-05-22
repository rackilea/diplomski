SearchHit[] results = sr.getHits().getHits();
        for(SearchHit hit : results){

            String sourceAsString = hit.getSourceAsString();
            if (sourceAsString != null) {
                Gson gson = new GsonBuilder().setDateFormat(dateFormat)
                        .create();
                System.out.println( gson.fromJson(sourceAsString, Firewall.class));
            }
        }