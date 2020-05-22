import java2.org.apache.commons.io.filefilter.WildcardFileFilter;
    import java.io.*;
    public class DeleteSameType{
    public static void main(String []args){

    DeleteSameType deleteSameType = new DeleteSameType();

        File dir = new File("user/document/test");

    deleteSameType.recursiveDelete(dir)        

    }

    private void recursiveDelete( File dir) {

    FileFilter fileFilter = new WildcardFileFilter("*.txt");
    if(dir.isDirectory()) {
        File[] files = dir.listFiles(fileFilter);
          for(File f: files){
                recursiveDelete(f);
        } 

        }
    dir.delete();
    }
}