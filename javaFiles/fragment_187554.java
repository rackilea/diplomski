return StreamEx.of(names)
               .cross(name -> getTokensForPerson(name).stream())
               // Here we have the stream of entries 
               // where keys are names and values are tokens
               .filterValues(Token::isValid)
               .mapKeyValue(Person::new)
               .toList();