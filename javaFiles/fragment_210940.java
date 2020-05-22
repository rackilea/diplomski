URLConnection con = null;
    InputStream in = null;
    try {
        String webadd="urls go here try the two you have had probelms with and success";
        URL url = new URL(webadd);

        con = url.openConnection();
        con.setConnectTimeout(10000);
        con.setReadTimeout(10000);
        in = con.getInputStream();
        Image img = ImageIO.read(in);
        if (img != null) {
            System.out.println("Loaded");
        } else {
            System.out.println("Could not load");

        }
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        if(is != null) {
            try {
                 is.close();
            } catch(IOException ex) {
                 // handle close failure
            }
        }

        if(con != null) {
            con.disconnect();
        }
    }
}