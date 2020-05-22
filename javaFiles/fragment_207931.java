class WSResponse<T extends WSError> {
    protected List<T> errors;

    public List<T> getErrors(){
        if(errors == null){
            setErrors(Collections.<T>emptyList());
        }

        return errors;
    }

    public void setErrors(List<T> errors) {
        this.errors = errors;
    }
}