Object obj = in.readObject();
Iterable<?> ar = (Iterable<?>) obj;

orders = new ArrayList<>();
for (Object x : ar) {
    orders.add((Vehicle) x);
}