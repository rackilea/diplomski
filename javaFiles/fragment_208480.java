Map<NameAndAge, NameAndSalary> map = new HashMap<>();
nameAndAgeList.forEach(age -> {
     NameAndSalary salary = nameAndSalaryList.stream().filter(
              s -> age.getName().equals(s.getName())).
              findFirst().
              orElseThrow(IllegalStateException::new);
      map.put(age, salary);
});