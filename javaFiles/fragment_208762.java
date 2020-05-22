class Car {
    private final int id;
    private String name;
    public Car(int i, String name) {
        this.id = i;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if (!(obj instanceof Car)) return false;        
        Car car = (Car) obj;        
        if(car.getId() == this.getId())
            if(car.getName().equals(this.getName()))
                return true;          
        return false;
    }
    public static final Attribute<Car, Car> CAR = new SimpleAttribute<Car, Car>() {
        @Override
        public Car getValue(Car car, QueryOptions queryOptions) {
            return car;        
        }
    };
    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", name=" + name + '}';
    }
}