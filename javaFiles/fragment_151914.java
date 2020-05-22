HttpGet get = new HttpGet(url[0]);
            HttpResponse response = client.execute(get);
            Log.e("result", "Response" + response);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            return result;