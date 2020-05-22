try {
        // Open connection
        HttpURLConnection httpConn = (HttpURLConnection) conn;

        // remainder omitted

    } catch (IOException ex) {
        try {
            throw new IOException("Error connecting");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //return menuItems;