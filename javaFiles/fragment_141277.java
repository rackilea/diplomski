try {
        URL url = new URL("http://xserve.uopnet.plymouth.ac.uk/modules/INTPROJ/PRCS251M/token");

        parameters = new HashMap<>();
        parameters.put("username", mEmail);
        parameters.put("password", mPassword);
        parameters.put("grant_type", "password");

        set = parameters.entrySet();
        i = set.iterator();
        postData = new StringBuilder();

        for (Map.Entry<String, String> param : parameters.entrySet()) {
            if (postData.length() != 0) {
                postData.append('&');
            }

            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }

        postDataBytes = postData.toString().getBytes("UTF-8");

        // set up connection
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        urlConnection.setConnectTimeout(5000);
        urlConnection.setReadTimeout(5000);
        urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        urlConnection.setRequestMethod("POST");
        urlConnection.getOutputStream().write(postDataBytes);

        // If request was good
        if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            reader = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();
        }

        Log.v("Login Response Code", String.valueOf(urlConnection.getResponseCode()));
        Log.v("Login Response Message", String.valueOf(urlConnection.getResponseMessage()));
        Log.v("Login Returned String", result.toString());


        jsonObject = new JSONObject(result.toString());
        token = jsonObject.getString("access_token");

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        urlConnection.disconnect();
        if (token != null) {
            jsonObject = driverInfo(token);

        }
    }