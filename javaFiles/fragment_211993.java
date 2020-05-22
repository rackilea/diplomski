double num = sales * 1.5 + 5000;
ArrayList<Double> salesArList = new ArrayList<Double>();
double i = sales;
do{
    salesArList.add(i);
    i = i + 5000;
}while(i <= num);