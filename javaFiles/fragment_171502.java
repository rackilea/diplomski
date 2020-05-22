@Override
protected Object clone() throws CloneNotSupportedException {

        MyModel model = (MyModel) super.clone();        
        model.setId(null);

        //-- Other fields to be altered, copying composite objects if any

        return model.   
}