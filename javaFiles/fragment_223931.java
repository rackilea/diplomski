class MyJerseyOrWhateverComponentThatWantsToAccessApplicationContext {

    public void foo() {
       ApplicationContext ctx = ApplicationContextHolder.INSTANCE.getCtx();
       ... 
       ctx.getBean(...);
    }
}