@Override
public String getStringData() {
    synchronized (inputStream) {
        try {
            byte[] input = new byte[inputStream.available()];
            inputStream.read(input);
            String contents = new String(input);
            return contents;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Exception " + e);
            return null;
        }
    }
}