List<Person> filtered = persons.stream()
      .filter(p -> {
          if (!"John".equals(p.getName())) {
              return true;
          } else {
              System.out.println(p.getName());
              return false;
          }})
      .collect(Collectors.toList());