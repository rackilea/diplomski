class ClassTwo {

    private MainActivity activity;

    ClassTwo(MainActivity activity) {
        this.activity = activity;
    }

    void disableAll() {
        activity.btn1.setEnabled(false);
        //etc...
    }

}