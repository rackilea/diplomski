class Car {
    public Car (String name, int price, int, tax, int year){
        constructor.......
    }

    public int computeCars(){
        return totalprice= price+tax;
    }

    public void printComputeCars(){
        System.out.println (name + "\t" + computeCars() +"\t" + year );
    }
}

public static void processCar(ArrayList<Car> cars){
    int totalAmount=0;
    for (int i=0; i<cars.size(); i++){
        totalAmount=+ cars.get(i).computeCars();
    }
}