String s = "1 56 123 30 0";

Iterator<Double> it = new DoubleIterator(new ByteArrayInputStream(s.getBytes()));
while(it.hasNext()) {
    System.out.println(it.next());
}
it = new NoiseIterator(new DoubleIterator(new ByteArrayInputStream(s.getBytes())));
while(it.hasNext()) {
    System.out.println(it.next());
}