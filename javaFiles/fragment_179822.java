public class Utils {
    public static FileAttachment[] genAttachments() {
        FileAttachment[] retVal = new FileAttachment[100];
        for( int i = 0; i < retVal.length; i++ )
            retVal[i] = new FileAttachment( "MyDoc"+i, "doc" );
        return retVal;
     }
}