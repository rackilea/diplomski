public class Person {
    private double money;

    public double getMoney()
        return money;
    }
    ...
}

public class Car {
    private List<Person> persons;

    public double getMoney {
        double result = 0.0;
        for (Person person: persons) {
            result += person.getMoney();
        }
        return result;
    }
    ...
}

public class Train {
    private List<Car> cars;

    public double getMoney() {
        double result = 0.0;
        for (Car car : cars) {
            result += car.getMoney();
        }
        return result;
    }
    ...
}