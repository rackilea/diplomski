expect(a.getB((String)anyObject())).andAnswer(new IAnswer<MyClass>() {
    public MyClass answer() {        
        String in = (String) getCurrentArguments()[0];
        switch(in) {
            case: "string1":
                return a;
            case: "string2":
                return b;
            default:
                return c;
        }
    }
});