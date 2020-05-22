public abstract class AbstractClass {

    public abstract String m();

    public AbstractClass get(){
        return new AbstractClass() {

            @Override
            public String m() {
                return "Anonymous " + AbstractClass.this.m(); 
            }
        };
    }

}