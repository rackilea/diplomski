private ImmutableListMultimap<PersonGroup, SomeClass> getGrouped() {
        return Multimaps.index
                (someClassList, new Function<SomeClass, PersonGroup>() {
                    public PersonGroup apply(SomeClass someClass) {
                        return new PersonGroup(someClass.getName(), someClass.getInputDate(), someClass
                                .getOutputDate(), someClass.getValue());
                    }
                });
    }