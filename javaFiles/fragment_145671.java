Iterator<String> iter = reader.lines().iterator();
long counter = 0;
while (iter.hasNext()) {
    counter++;
    System.out.println("counter=" + counter);
    capturedCommandOutput.add(iter.next());
}