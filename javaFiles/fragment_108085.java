List<Integer> list = new ArrayList<>();
for (int i = 0; i < 255; i++) {
     list.add(i);
}
//and here is the point. Java already have this implemented for you
Collections.shuffle(list);