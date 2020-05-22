private class setPerson implements DoActivity{
    @Override
    public Object execute(final Object ...params){
        if(params.length != 2)
            throw new RuntimeException(
                "setPerson must take an array of exactly two strings");
        try{
            final String name = (String)params[0];
            final String telephone = (String)params[1];
            ...
            return null;
        } catch(ClassCastException cce){
            throw new RuntimeException(
                "setPerson must take an array of exactly two strings");
        }
    }
}