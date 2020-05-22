Test test = mapper.readValue(json, KeyPhrase.class);
    System.out.println("cp");

    for(Test.Results res : test.getD().getResults()){
        System.out.println(res.Synonym);
}