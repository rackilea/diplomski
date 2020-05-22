public class MoveForLoopRight extends IntersectionSimulation {
        public void run() {
            // It is important to know the relative distance between each car. If not, your cars would stack on each other.
            int distance = 0;
            for (int i = 0; i< carsright.size(); i++) {
                CarsRight car = carsright.get(i);
                if (car.getX() <= 300) { // If they are before signal, move them till the line maintaining the distance
                    car.move(mkl.b, distance); // move method needs distance between cars
                    distance = distance + car.getLength() + 50; // 50 is the gap between each car
                } else {
                    car.move(mkl.b,  0); // these cars crossed the signal. They can move freely and don't need any distance
                }
            }
        }
    }