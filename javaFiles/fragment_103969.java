public class Help {

public static double printSeries(int ch1, int ch2){
    double mi=0;
    double iPlusOne=0;
    for (int i=ch1; i <= ch2; i++){
        iPlusOne = i+1;
        mi += i/iPlusOne; 
        System.out.println(i + "      "  + mi);

    }// end of for loop
    return 0.00;
}// end of printSeries method

public static void main(String args[]){
    printSeries(1, 20);
}// end of main method

}// end of class