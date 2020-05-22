class ClassA implements MyInterface { ... }
class ClassB implements MyInterface { ... }

class MyFactory {
    public MyInterface create(int dayOfTheWeek) {
        if (dayOfTheWeek == 0) {
            return new ClassA();
        } else {
            return new ClassB();
        }
    }
}