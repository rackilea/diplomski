MyClass myClass = new MyClass();  
List<Integer> input = Arrays.asList(1, 2, 3);

Method method = MyClass.class.getDeclaredMethod("childMethod", List.class);
method.setAccessible(true);
method.invoke(myClass, input);
....