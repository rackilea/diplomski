public static void main(String[] args) {
Scanner kbd = new Scanner(System.in);


System.out.print("\n\n"
    + "Drawing Rectangles\n"
    + "------------------\n\n");

int height = -1, width = -1;
System.out.print("Enter the height and width of a rectangle: ");
height = kbd.nextInt();
width = kbd.nextInt();
kbd.nextLine();
while(height > -1) {
    System.out.println("\n" + "Here is your rectangle:");
    drawRectangle(height, width);
    System.out.print("\n\n");

    System.out.print("Enter the height and width of a rectangle: ");
    height = kbd.nextInt();
    width = kbd.nextInt();
    kbd.nextLine();
}


}

private static void drawRectangle(int height, int width) {

for (int line = 1; line <= height; line++) {
    for (int star = 1; star <= width; star++) {
        System.out.print("*");

    }

    System.out.println();
}
}