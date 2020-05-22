import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Grouping {

    static final class Person {
        private final int age;
        private final String city;
        private final String doj;
        private final double salary;

        public Person(int age, String city, String doj, double salary) {
            this.age = age;
            this.city = city;
            this.doj = doj;
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public String getCity() {
            return city;
        }

        public String getDoj() {
            return doj;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Person{" +
                "age=" + age +
                ", city='" + city + '\'' +
                ", doj='" + doj + '\'' +
                ", salary=" + salary +
                '}';
        }
    }

    enum Property {
        AGE {
            @Override
            protected Object extractValue(Person person) {
                return person.getAge();
            }
        },
        CITY {
            @Override
            protected Object extractValue(Person person) {
                return person.getCity();
            }
        },
        DOJ {
            @Override
            protected Object extractValue(Person person) {
                return person.getDoj();
            }
        };

        protected abstract Object extractValue(Person person);

        public PropertyValue toValue(Person person) {
            return new PropertyValue(this, extractValue(person));
        }
    }

    static final class PropertyValue {
        private final Property property;
        private final Object value;

        public PropertyValue(Property property, Object value) {
            this.property = property;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            PropertyValue that = (PropertyValue) o;
            return property == that.property &&
                Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(property, value);
        }

        @Override
        public String toString() {
            return "PropertyValue{" +
                "property=" + property +
                ", value=" + value +
                '}';
        }
    }

    private static List<PropertyValue> createGroupingKey(List<Property> properties, Person person) {
        return properties.stream().map(property -> property.toValue(person)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
            new Person(25, "NYC", "02/25/2018", 50000),
            new Person(25, "MEX", "02/25/2017", 70000),
            new Person(26, "MEX", "02/25/2017", 80000)
        );

        // TODO ask the user, rather than hardcoding
        List<Property> groupingProperties = Arrays.asList(Property.CITY, Property.DOJ);

        Map<List<PropertyValue>, Double> salaryAggregatedByChosenProperties =
            persons.stream()
                   .collect(Collectors.groupingBy(p -> createGroupingKey(groupingProperties, p),
                                                  Collectors.summingDouble(Person::getSalary)));

        System.out.println("salaryAggregatedByChosenProperties = " + salaryAggregatedByChosenProperties);
    }
}