class ClassTwo {

    ClassTwo(){} //Default, empty constructor

    void disableAll(Button[] btns) {
        for (Button btn : btns) {
            btn.setEnabled(false);
        }
    }

}