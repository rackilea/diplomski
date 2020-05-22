public static void main(String[] args) throws IOException {

        String src="C:\\Users\\sahug\\Downloads\\split\\dumps.txt";
        String dest="C:\\Users\\sahug\\Downloads\\split\\";
        String fileName="MyFile";
        FileInputStream fis = new FileInputStream(str);
        int size = 20;
        byte buffer[] = new byte[size];

        int count = 0;
        while (true) {
            int i = fis.read(buffer, 0, size);
            if (i == -1)
                break;

            String filename = fileName + count;
            FileOutputStream fos = new FileOutputStream(dest+filename);
            fos.write(buffer, 0, i);
            fos.flush();
            fos.close();

            ++count;
        }
    }