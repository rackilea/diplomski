String[] myArray = { "a", "b", "c", "d" };
OptionalInt c = IntStream.range(0, myArray.length).filter(n -> "c".equals(myArray[n])).findFirst();

if (c.isPresent()) {
   System.out.println(c.getAsInt());
}

>>>> 2