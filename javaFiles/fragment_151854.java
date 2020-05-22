public class Bar extends Foo {
    @Override
    public void spam() {
        objectWhichRequireCallback(new Callback {
            @Override
            public void onCallback() {
                Bar.super.spam();
            }
        });
    }
}