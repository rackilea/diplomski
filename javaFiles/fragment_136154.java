import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class FileFinder
{
    private String mInputFileLocation;
    private List<String> mSampleList;
    private List<String> mRefundList;

    public FileFinder(String inputFileLocation)
    {
        mInputFileLocation = inputFileLocation;
        mSampleList = new LinkedList<String>();
        mRefundList = new LinkedList<String>();
    }

    public void processList(List<String> filenameList)
    {
        for (String filename : filenameList)
        {
            File f = new File(mInputFileLocation, filename);
            if (f.exists())
            {
                if (filename.startsWith("sample_"))
                {
                    mSampleList.add(filename);
                }
                else if (filename.startsWith("refund_"))
                {
                    mRefundList.add(filename);
                }
            }
        }
    }

    public List<String> getSampleList()
    {
        return mSampleList;
    }

    public List<String> getRefundList()
    {
        return mRefundList;
    }
}