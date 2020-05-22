return Arrays.stream(names)
        .<Person>flatMap(
                name -> getTokensForPerson(name).stream()
                        .filter(Token::isValid)
                        .map(token -> new Person(name, token)))
        .collect(Collectors.toList());