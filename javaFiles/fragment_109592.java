List<Integer[]> nodes = new ArrayList<Integer[]>();
nodes.add(new Integer[] {1,1});
Integer[] lookingFor = new Integer[] {1,1};
int index = -1;
for (int i = 0; i < nodes.size(); i++) {
    Integer[] array = nodes.get(i);
    if (Arrays.equals(lookingFor, array)) {
        index = i;
        break;
    }
}
System.out.println(index); // 0