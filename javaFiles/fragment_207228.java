public class Finally {

    public void abc() {
        try {
            throw new OutOfMemoryError();
        } finally {
            byte[] b = new byte[1024*1024*1024];
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {
        new Finally().abc();
    }
}