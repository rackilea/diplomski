public ClickHandler(Method method) {

    try {
        OtherClass.responseMethod(method);
    } catch (Exception e) {
        e.printStackTrace();
    }

}