List<MyObject> domain = new ArrayList<>();
domain.add(new MyObject(1, "John", "Smith"));
domain.add(new MyObject(1, "Bob", "Bailey"));

// using the verbose statement of function (rahter than a lambda) 
// to make it easier to see how the map function works
List<MyDto> asDto = domain.stream().map(new Function<MyObject, MyDto>() {
    @Override
    public MyDto apply(MyObject s) {
        // a simple mapping from domain to dto
        return new MyDto(s.getId(), s.getFirstName() + " " + s.getLastName());
    }
}).collect(Collectors.toList());

System.out.println(asDto);