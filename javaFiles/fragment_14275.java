public static void main(String[] args) {

    Map<Integer, double[]> hmap = new HashMap<>();

    int id = 0;
    for (double height = 9.0 ; height >= 6.0; height -=0.6) {

        for (double width = 3.0 ; width <= 6.0; width+=0.6) {

            hmap.put(id++, new double[] {width, height}) ;
        }
    }

    //output 
    for(Integer iD : hmap.keySet()) {

        System.out.printf("%2d  %3.2f %s %3.2f \n",iD,hmap.get(iD)[0],"-",hmap.get(iD)[1]);
    }
}