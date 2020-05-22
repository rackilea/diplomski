Enum<?> e = Thread.State.BLOCKED;

// produces "incompatible types: Enum<CAP#1> cannot be converted to Enum<CAP#2>"
Arrays.asList(e).set(0, e);

// works since Java 8
List<Enum<?>> list=Arrays.asList(e);
list.add(e);

// works even in older versions
Arrays.<Enum<?>>asList(e).set(0, e);