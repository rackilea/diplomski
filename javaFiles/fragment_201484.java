Person person = ...
PageRequest page = ...
ExampleMatcher matcher = ExampleMatcher.matching().withMatcher(
                               "lastname", 
                               ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING).ignoreCase()
                         );
return personRepository.findByExample(Example.of(person, matcher), page).getContent();