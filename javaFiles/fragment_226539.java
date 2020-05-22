public enum APIErrorCode {

    APIErrorOne(1),
    APIErrorTwo(27),
    APIErrorThree(42),
    APIErrorFour(54);

    private final int code;

    private APIErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static APIErrorCode getAPIErrorCodeByCode(int error) {
       if(Util.errorMap.containsKey(error)) {
         return  Util.errorMap.get(error);
       }
       //Or create some default code
       throw new IllegalStateException("Error code not found, code:" + error);
    }

    //We need a inner class because enum are  initialized even before static block
    private static class Util {

        private static final Map<Integer,APIErrorCode> errorMap = new HashMap<Integer,APIErrorCode>();

        static {

            for(APIErrorCode code : APIErrorCode.values()){
                errorMap.put(code.getCode(), code);
            }
        }

    }
}