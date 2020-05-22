private static List<WeakReference<Car>> cars = new ArrayList<WeakReference<Car>>();

public static synchronized Car createCar(int id) {
   WeakReference<Car> result= new WeakReference<Car>(new Car(id));
   int index= cars.indexOf(result);
   if (index==-1){
      cars.add(result);
      return result.get();
   } else {
      return cars.get(index).get();
   }
}