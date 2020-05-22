public static void main(String[] args) {
    Random rand = new Random();

    float result = rand.nextFloat() * (-1f - (-30f)) + (-30f);

    System.out.println(result);
}