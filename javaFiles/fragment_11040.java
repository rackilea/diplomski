import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class SortExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<fileObj> fileView = new ArrayList<fileObj>();
        for(int j=0; j<10; j++)
               {
                 fileView.add(new fileObj(j));
               }
        Collections.sort(fileView);

        for(fileObj obj: fileView){
            System.out.println("File " + obj.getDiffSeconds());
        }


    }

}
class fileObj implements Comparable<fileObj>
{
    public String fileName; 
    public Date modificationTime; 
    public long diffSeconds;     

    fileObj()
    {
        modificationTime = null; 
    }

    fileObj(long diffSeconds)
    {
        modificationTime = null;
        this.diffSeconds = diffSeconds;
    }

    @Override
    public int compareTo(fileObj arg0) {

        if(this.diffSeconds > arg0.diffSeconds )
        return 0;
        else return 1;
    }

    public long getDiffSeconds() {
        return diffSeconds;
    }

    public void setDiffSeconds(long diffSeconds) {
        this.diffSeconds = diffSeconds;
    }
}