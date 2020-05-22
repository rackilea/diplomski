// Using Class2
Map<MyEnum , List<Class2>> mapX = null;
mapX.entrySet().forEach(entry -> {
        System.out.println("MapX-Key : " + entry.getKey() + "\nMapX-Value : "
                + entry.getValue().stream()
                .collect(Collectors.summingInt(x -> x.getX() + x.getY())));
});

// Values from Class2 via Class1
Map<MyEnum , List<Class1>> map1 = null;
map1.entrySet().forEach(entry -> {
        System.out.println("MapX-Key : " + entry.getKey() + "\nMapX-Value : "
                + entry.getValue().stream()
                .collect(Collectors.summingInt(x -> x.getClass2().getX() + x.getClass2().getY())));
});