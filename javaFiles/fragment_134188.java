List<Person> result = personList.stream()
        .filter( person -> person.phoneNumber.stream()
                                 .anyMatch(phone -> phone.type.equals("HOME") && 
                                                    phone.number.contains("888"))
        .map(person -> {
            List<Phone> phones = person.phoneNumber.stream()
                                    .filter(phone -> phone.type.equals("HOME") && 
                                                    phone.number.contains("888"))
                                    .collect(Collectors.toList());
            return new Person(person.firstName, person.lastName, person.age, person.id, phones);
        })
        .collect(Collectors.toList());