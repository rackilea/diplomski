interface ITest{};

class TestImpl implements ITest {}

usage:
resolver.addMapping(ITest.class, TestImpl.class);