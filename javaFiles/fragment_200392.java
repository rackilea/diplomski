void setBToJustTest(TestA a) {
    a.setB("JUST_TEST");
}

//later
testAList.stream().filter(this::isStreams).forEach(this::setBToJustTest);