class Label implements Validatable {
    String label;
    @Override
    public void validate() throws BaseValidationException {
         //Check conditions and throw the proper exceptions.
         //Label class should know which validations are user and 
         //Which are presentation and throw appropriate exceptions.
    }
}