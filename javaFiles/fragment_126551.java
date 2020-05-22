public static void main(String[] args) {
    List<String> stringList = Arrays.asList("f1,f2", "f2,f3", "f4,f5", "f2,f1", "f5,f4");
    Set<String> result = new HashSet<>();
    for (String s : stringList) {
        String[] elements = s.split(",");
        Arrays.sort(elements);
        result.add(Arrays.toString(elements));
    }

    for (String e : result){
        System.out.println(e);
    }
}