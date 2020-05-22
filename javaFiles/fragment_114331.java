public class CustomOptional extends Optional {

    public CustomOptional(){
        super(new Token("null", null, new Token("NULL", null)));
    }


    public CustomOptional(final CellProcessor next) {
        super(new Token("null", null, new Token("NULL", null, next)));
    }

}