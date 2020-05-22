class MyFieldWrapper {

    Map<MyObject, String> myField;
    ....

    public void forEach(BiConsumer<? super MyObject, ? super String> action){
        myField.forEach(action);
    }
}