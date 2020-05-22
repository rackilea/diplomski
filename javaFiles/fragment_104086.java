Map<String, List<Age>> map = list2.stream()
    .collect(Collectors.groupingBy(             // Map<String, List<Age>>
         Age::getName));                        // ... where 'name' is the key

final  Iterator<Employee> iterator = list1.iterator();
while (iterator.hasNext()) {                    // Iterating List<Employee>
    final Employee e = iterator.next();         // Employee
    if (map.containsKey(e.getName())) {         // If there is Age with equal 'name'
        final String age = map.get(e.getName()) // ... get the first found age
            .get(0).getAge();
        e.setAge(age);                          // ... set it to the Employee
    } else iterator.remove();                   // ... or else remove the Employee
}