finally {
    if (fr != null) {
        try {
            fr.close();
        } catch(IOException e) {
            //...
        }
    }
    if (fw != null) {
        try {
            fw.close();
        } catch(IOException e) {
            //...
        }
    }
}