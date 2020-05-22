public class House {

    public static void main(String[] args) {
        final int HEIGHT = 6;
        final int WIDTH = 9;

        for (int i = 0; i < HEIGHT * 2; i += 2) {
            for (int j = 0; j < WIDTH; j++) {// check for roof
                if ((i + (i % 2) + (WIDTH) / 2) < j // right slope
                        || (i + (i % 2) + j) < (WIDTH) / 2)// left slope
                {
                    System.out.print(" ");
                } else {
                    if ((i / 2 >= HEIGHT * 2 / 3) && (j >= WIDTH / 2) && j < WIDTH / 2 + HEIGHT / 3) {// check for door
                        System.out.print(" ");
                    } else {// solid then
                        System.out.print("*");
                    }
                }
            }
            System.out.println();
        }

    }
}