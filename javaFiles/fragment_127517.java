// Interface declaration
List<Fruit> myMethod();

// Implemented by...
public List<Banana> myMethod() {
    return new ArrayList<Banana>();
}

// Called as:
List<Fruit> fruit = foo.myMethod();
fruit.add(new Apple());