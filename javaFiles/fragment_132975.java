int cnt = 0;
List<Direct> list = new LinkedList<>();
for (Direct d : list) {
    if (name.equals(d.getName())) {
        return cnt;
    }
    cnt++;
}