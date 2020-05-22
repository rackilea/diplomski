List<String> list = Arrays.asList("StudentName", "Department", "grade", "comment");

List<String> filteredList = list.stream()
    .filter(s -> Character.isLowerCase(s.charAt(0)))
    .collect(Collectors.toList());

System.out.println(filteredList); // prints "[grade, comment]"