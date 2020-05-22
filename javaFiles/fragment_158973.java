List<PersonInfo> personInfos = persons.stream().flatMap(person -> person.getCurrAndPrevAddrs().stream().map(addr -> {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setName(person.getName());
        personInfo.setAge(person.getAge());
        personInfo.setAddrs(addr);              
        return personInfo;
})).collect(Collectors.toList());