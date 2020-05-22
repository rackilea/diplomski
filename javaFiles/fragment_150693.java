abstract class SFoo {
    void bar() {}
}

class SFoobar extends SFoo {
    void bar() throws Exception {
        throw new Exception("hi there");
    }
}