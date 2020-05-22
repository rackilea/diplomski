@Override
public void configure() throws Exception {
    from(...)
    .process(...)
    .to(...)
    .choice()
        when(myBooleanPredicate).to(...)
    .endChoice();
}