package anoop;


import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class DataTrim  extends UDF{

    public Text evaluate(Text incomingData){
        String trimmed;
        trimmed= incomingData.toString().trim();
        return new Text(trimmed);
    }


}