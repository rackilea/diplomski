Map<Character, ShapeFactory> dict = new HashMap<>();
dict.put('C', new CircleFactory());
dict.put('R', new RectangleFactory());
dict.put('T', new TriangleFactory());

...

ShapeFactory factory = dict.get(symbol);
Shape shape = factory.create(data);