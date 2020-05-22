static {
    Vehicle honda = new Car("honda", 4);
    Vehicle toyota = new Car("toyota", 2);    
    Vehicle bicycle = new Bicycle("bicycle");    
    garaghes[0] = new Garage("First", new Vehicle[] {honda, toyota, bicycle});

    Vehicle fiesta = new Car("ford", "fiesta");
    Vehicle pickup = new Car("ford", Car.Type.PICKUP);
    garaghes[1] = new Garage("Second", new Vehicle[] {fiesta, pickup});
}