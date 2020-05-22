System.out.println(curr.getData());
remove(0);
if (curr.getData() % 2 == 0) {
    evens.add(curr);
} else {
    odds.add(curr);
}
split(odds, evens);