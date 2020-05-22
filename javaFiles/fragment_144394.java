public static void main(String[] args) {
    Color currentColor = Color.BLUE;
    for(;;) {
        System.out.println(currentColor);
        currentColor = currentColor.next();
    }
}