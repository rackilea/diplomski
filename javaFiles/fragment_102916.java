BufferedReader reader = null;
    try {
        reader = new BufferedReader(new InputStreamReader(mmInStream));
        String line = null;
        while ((line = reader.readLine()) != null) {
        System.out.println(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (reader != null) {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        connectionLost();
    }