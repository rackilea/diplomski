boolean isStreams(TestA a) {
    return "STREAMS".equals(a.getA());
}

//later
if(testAList!=null) {
    testAList.stream().filter(this::isStreams).forEach(a -> a.setB("JUST_TEST"));
}