List<Apple> apples = new List<Apples>();
// Again, not allowed
List<Fruit> fruit = apples;

// Because this would be odd...
fruit.Add(new Banana());

// It's a Banapple!
Apple apple = apples.get(0);