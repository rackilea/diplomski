final String json = "{\"people\":[],\"company\":{}}"; // refer to JSON above
    System.out.println(new JSONPath("people[0].name").getWithin(json)); // Optional[Eric]
    System.out.println(new JSONPath("people[1].name").getWithin(json)); // Optional[Karin]
    System.out.println(new JSONPath("people[2].name").getWithin(json)); // Optional.empty
    System.out.println(new JSONPath("people[0].age").getWithin(json));  // Optional[28]
    System.out.println(new JSONPath("company").getWithin(json));        // Optional.empty
    System.out.println(new JSONPath("company.name").getWithin(json));   // Optional[Elm Farm]