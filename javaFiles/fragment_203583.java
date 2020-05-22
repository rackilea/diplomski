class MyVisitor extends GrammarStackBaseVisitor<Object> {
    @Override
    public Object visitCarDef(GrammarStackParser.CarDefContext ctx) {
        List<Car> cars = new ArrayList<Car>();
        // now for each car inside carDef
        for (GrammarStackParser.CarContext carCtx : ctx.car()) {
            Car car = (Car)visitCar(carCtx); // here is the recursion!
            cars.add(car);
        }
        return cars;
    }
    @Override
    public Object visitCar(GrammarStackParser.CarContext ctx) {
        String type = car.type().getText();
        return new Car(type);
    }
}