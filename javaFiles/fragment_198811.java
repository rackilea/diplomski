Object obj = in.readObject();
ArrayList<?> ar = (ArrayList<?>) obj;

orders.clear();
for (Object x : ar) {
    orders.add((Vehicle) x);
}