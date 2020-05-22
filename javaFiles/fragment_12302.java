public String clickDisplayFoos(){
    List<Foo> foos =  service.getFoos();
    for(iterate through foos){
        foo.setValidAction(session.hasSecurityRole())
    }
    String json = objMapper.writeValueAsString(foobeans);
    return json;
}