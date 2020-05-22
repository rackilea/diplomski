public static void DrawMeACircle(int posX, int posY, int radius) {
    int h = 10; // Initial x position.
    int k = 5; 

    int x = posX - h;
    int y = posY - k;

    for (int i = 0; i <= 2*posX; i++){
        for (int j = 0; j <= 2*posY; j++){
            double dx = (x - i);
            double dy = (y - j);

            if (Math.abs(dx*dx + dy*dy - radius*radius) < 5){
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}