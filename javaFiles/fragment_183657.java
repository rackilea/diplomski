Map<String, Set<Integer>> map = new HashMap<String, Set<Integer>>();
map.put("Foo", new HashSet<Integer>(Arrays.asList(1, 2, 3)));
map.put("Bla", new HashSet<Integer>(Arrays.asList(4, 5, 6)));

File file = new File("data.bin");
ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
try {
    out.writeObject(map);
    out.flush();
} finally {
    out.close();
}