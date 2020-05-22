public static void main(String args[]) throws Exception {
        byte[] b = myFunction();
//      String bstring = b.toString(); // don't do this
        String bstring = new String(b, "UTF-8");
        byte[] ser = bstring.getBytes("UTF-8");
        /* Here the methode to convert the bstring to byte[], and call it ser */
        String deser = new String(ser, "UTF-8");
    }