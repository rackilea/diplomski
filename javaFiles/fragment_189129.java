new AbstractRulesModule() {
    @Override
    protected void configure() {
        forPattern("root").createObject().ofType(Root.class);
        forPattern("root/person").createObject().ofType(Person.class).then()
                .callMethod("setId").withParamCount(1).then()
                .callParam().ofIndex(0).fromAttribute("id").then()
                .setNext("setPerson");
        }
}