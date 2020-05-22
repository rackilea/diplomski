BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    try {
        String line;
        while ((line = reader.readLine()) != null) {
             String[] RowData = line.split(",");
             date = RowData[0];
             value = RowData[1];
            // do something with "data" and "value"
        }
    }
    catch (IOException ex) {
        // handle exception
    }
    finally {
        try {
            is.close();
        }
        catch (IOException e) {
            // handle exception
        }
    }