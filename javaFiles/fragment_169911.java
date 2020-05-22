// Prepare your readers and their top items
for(File f: dir.listFiles()) {
    BufferedReader br = new BufferedReader(new FileReader(f));
    String firstLine = reader.readLine();
    // Your code inserts buffered readers unconditionally;
    // You should not insert readers for empty files.
    if (firstLine != null) {
        readers.add(br);
        list.add(firstLine);
    } else {
        br.close();
    }
}
// Stop when the last reader is removed
while (!readers.isEmpty()) {
    int minIndex = ... // Find the index of the smallest item in the "list"
    out.write(list.get(minIndex));
    BufferedReader br = readers.get(minIndex);
    String next = br.readLine();
    if (next != null) {
        list.set(minIndex, next);
    } else {
        br.close();
        list.remove(minIndex);
        readers.remove(minIndex);
    }
}