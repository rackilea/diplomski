public static void main(String[] args) {
     for(int ID=0; ID<3; ID++){
         Car car = speedup(ID);
         System.out.println(car.accelerate(50));
     }

}

public static Car speedup(int ID) {
     switch(i){
     case 0: return new Fortuner();
     case 1: return new Hondacity();
     case 2: return new Omni();
     }
     return null;
}