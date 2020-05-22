BufferedReader reader = new BufferedReader(yourInputStreamReader,8);

        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }