public class SomeOtherClass {
    public static void someOtherMethod(int requestCode, int resultCode, Intent data){
        ...
    }
}


@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    SomeOtherClass.someOtherMethod(requestCode,resultCode,data);
    ...
}