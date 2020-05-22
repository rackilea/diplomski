//I need to get the people older than 50 years old, present to the user and wait for a click. If the list is empty, do something, if it's not do something else.

      buttonRefresh.onClickListener(() -> {
          List<Person> people = model.requestPeople();

          people = people.stream()
                      .filter(p -> p.getAge > 50) 
                      .collect(Collectors.toList())

          [code to create an adapter]

          if(people.isEmpty()){
             [do something...]
          } else{
             [do something else...]
          }

      })