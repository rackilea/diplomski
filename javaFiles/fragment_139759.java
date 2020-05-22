public static void main(String[] args){
    if (c == 1){
        //...
        double area1 = Integration.Areaf(lower, upper);
        double area2 = Integration.Areag(lower, upper);
        sum = area1 - area2;//sum and minus used?
        System.out.println("Area between the two curves = " + sum);
   }
}