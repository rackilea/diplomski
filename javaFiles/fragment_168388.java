public class OrderedCar{
   private int order;
   private Car car;

   public OrderedCar(int order, Car car){
      this.order = order;
      this.car = car;
   }

   public int getOrder(){
      return order;
   }

   public Car getCar(){
      return car;
   }
}