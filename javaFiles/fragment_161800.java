//JSON object.
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", register_username);
            jsonObject.put("password", register_password);

            //Entity builder to send value.
            EntityBuilder entityBuilder = EntityBuilder.create();
            entityBuilder.setText(jsonObject.toString());
            httpPost.setEntity(entityBuilder.build());

            //Getting response
            HttpResponse response = httpClient.execute(httpPost);
            String responseBody = EntityUtils.toString(response.getEntity());
            JSONObject responseObject = new JSONObject(responseBody);