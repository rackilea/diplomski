connection.connect();

    int status = connection.getResponseCode();

    switch (status) {
        case 200:
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
            String response = stringBuilder.toString();
            System.out.println("response : " + response);
    }