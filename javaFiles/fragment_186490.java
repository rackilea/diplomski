try(MyClass mc = new MyClass()) {
    mc.doWork();
    mc.doMoreWork();
    mc.someMoreWork();
} catch(SomeExceptionThatMayBeThrown e) {
    logger.log("Ooops", e);
}