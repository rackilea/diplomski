static int nb_stars=0;
/**
 * @param args the command line arguments
 */
public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    System.out.print("Please input the first integer for histogram1: ");
    nb_stars = in.nextInt();
    show_histogram();

    System.out.print("Please input the second integer for histogram1: ");
    nb_stars = in.nextInt();
    show_histogram();

    System.out.print("Please input the third integer for histogram1: ");
    nb_stars = in.nextInt();
    show_histogram();

}
public static void show_histogram(){
        for(int j=1; j<=nb_stars; ++j)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}