public class B {
    static public void main(String[] args) throws Exception {
        String str = "س";
        System.out.println(str);
        char key = 'N';
        byte bKey = (byte) key;

        byte[] b = str.getBytes("UTF8");

        System.out.println("Original bytes from str:");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        System.out.println("Bytes used to create str1:");
        for (int i = 0; i < b.length; i++) {
            b[i] = Byte.valueOf((byte) (b[i] ^ bKey));
            System.out.println(b[i]);
        }

        String str1 = new String(b, "Cp1256");

        b = str1.getBytes("Cp1256");

        System.out.println("Bytes retrieved from str1:");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
            b[i] = (byte) (b[i] ^ bKey);
        }

        System.out.println("Bytes used to create str2:");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        String str2 = new String(b, "UTF8");
        System.out.println(str2);
    }
}