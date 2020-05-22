List<Integer> data = new ArrayList<>();
data.add(1);
data.add(2);
data.add(3);

for (int i = 0; i < data.size(); i++) {
    System.out.println("before: " + data.get(i));
    if (i == 1) {
        data.remove(i);
    }
    System.out.println("after: " + data.get(i));
}