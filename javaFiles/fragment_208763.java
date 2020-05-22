IndexedCollection<Car> cars = new ConcurrentIndexedCollection<>();
cars.add(new Car(1, "test"));
cars.add(new Car(2, "test2"));
cars.add(new Car(3, "test3"));      
Car s = new Car(2, "test2");
ResultSet<Car> cs= cars.retrieve(QueryFactory.equal(Car.CAR, s));
cs.forEach(c -> System.out.println(c.toString()));