class Test {
    public static void main(String[] args) {
        int i = 0;
        float f = 1.0f;

        // Omitted code...

        // Here int:float is promoted to float:float:
        f = (b==0) ? i : 4.0f;
        System.out.println(1.0/f);
    }
}