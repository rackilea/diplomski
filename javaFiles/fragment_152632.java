public class CPPConnection extends ReactContextBaseJavaModule {
@ReactMethod
    public void GetDerivedUnits(String scheme,final Promise promise){
        try {

            List<String> returnSet = new ArrayList<String>();
            //Set first value so that there is a lead value
            returnSet.add("");
            returnSet.add(scheme);
            returnSet.add("lb");
            returnSet.add("kg");
            String[] returnArray = new String[returnSet.size()];
            returnArray = returnSet.toArray(returnArray);

            WritableArray promiseArray=Arguments.createArray();
            for(int i=0;i<returnArray.length;i++){
                promiseArray.pushString(returnArray[i]);
            }

            promise.resolve(promiseArray);
        }
        catch(Exception e){
            promise.reject(e);
        }
    }
}