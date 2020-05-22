public class MyFunction implements FREFunction {

    @Override
    public FREObject call(FREContext context, FREObject[] passedArgs) {      
        MyExtensionContext mec = (MyExtensionContext) context;
        // Set a local variable in MyExtensionContext to getActivity value
        mec.act = mec.getActivity();
        mec.doThreadWork();
        return null;
    }
}