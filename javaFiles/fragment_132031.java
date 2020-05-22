List<Integer> a = new ArrayList<>(Arrays.asList(1, 3, 1, 2));
List<Integer> b = Arrays.asList(1, 3);

for (Integer currentInt : b) {
    a.remove(currentInt);
}

System.out.println(a);