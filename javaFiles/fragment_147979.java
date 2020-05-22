List<Employee> javaEmpList =
    empList.stream()
           .filter(emp -> emp.getSkills()
                             .stream()
                             .anyMatch(skill -> skill.getLanguage().equalsIgnoreCase("Java")))
           .collect(Collectors.toList());