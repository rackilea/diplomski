package so.q48042638;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<List<String>> colors = new ArrayList<>();
        List<Car> cars = new ArrayList<>();

        Car car1 = new Car("Ford1");
        colors.add(generateColors(car1));
        car1.setColors(colors);
        cars.add(car1);

        Car car2 = new Car("Ford2");
        colors = new ArrayList<>();
        colors.add(generateColors(car2));
        car2.setColors(colors);
        cars.add(car2);

        Car car3 = new Car("Ford3");
        colors = new ArrayList<>();
        colors.add(generateColors(car3));
        car3.setColors(colors);
        cars.add(car3);

        for (Car c : cars) {
            System.out.println(c);
        }
    }

    private static List<String> generateColors(Car car) {
        List<String> opcje = new LinkedList<>();
        opcje.add(car.getName());
        return opcje;
    }
}