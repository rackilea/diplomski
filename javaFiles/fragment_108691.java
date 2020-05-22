List<Person> matchingPeople = 
     people.stream()
           .filter(p -> {
              if (dateFilters.stream()
                             .anyMatch(df -> numOfDaysBetween(p.getBirthDate(), df.getDate()) < df.getDiffRange()
)) 
              {
                  return true;
              } else {
                  //you can add here code to log elements that don't pass the filter
                  //or you can add these elements to an external List
                  return false;
              }
          })
          .collect(Collectors.toList());