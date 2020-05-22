Set<MyElementType> elements = EnumSet.allOf(MyElementType.class);
Iterator<MyElementType> it = elements.iterator();
while (it.hasNext()) {
    MyElementType el = it.next();
    // etc
}

// or
Iterator<MyElementType> it = Arrays.asList(MyElementType.values()).iterator();