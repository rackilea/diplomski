try (BufferedReader reader = new BufferedReader(new InputStreamReader(mmInStream))){
        String line = null;
        while((line = reader.readLine()) != null) {
        System.out.println(line);
        }
        connectionLost();
    } catch(IOException e) {
        e.printStackTrace();
    }