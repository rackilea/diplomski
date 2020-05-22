Car car = cars.get(0);
if (car instanceof Audi) {
    // It's an Audi, now you can safely cast it
    Audi audi = (Audi) car;
    // ...do whatever needs to be done with the Audi
}