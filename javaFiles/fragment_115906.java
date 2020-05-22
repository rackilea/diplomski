public class Car implements Comparable<Car> {

    ...

    public int compareTo(Car other)
    {
        return this.getBrand().compareTo(other.getBrand());
    }
}