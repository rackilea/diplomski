class confusion {
    public static void main(String[] args) {
    double trueP=6930;
    double trueN=6924;
    double falseP=0;
    double falseN=0;
    double str= (trueP + falseP) *(trueP + falseN) * (trueN + falseP) * (trueN + falseN);
               double output= Math.sqrt(str);
                if (output!= 0.0) {
                    double output2 =(trueP * trueN) / output;
                    System.out.println(output2);
            }
                else  {
                System.out.println(output); // Display the string.
            }
    }
}