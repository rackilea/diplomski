$ java -version
java version "1.7.0_51"
Java(TM) SE Runtime Environment (build 1.7.0_51-b13)
Java HotSpot(TM) 64-Bit Server VM (build 24.51-b03, mixed mode)
$ sha1sum lib/aws-java-sdk-1.8.6.jar
da97b2bd9d450c94300477008c750fbed1f56846  lib/aws-java-sdk-1.8.6.jar

$ cat src/sw/Question.java
package sw;

import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.util.*;

class Question
{
    public static void main(String[] args)
    {
        final String USAGE = "USAGE:  java "+Question.class.getName()+" ## no required args";
        try
        {
            //question:
            final String tableName = "some-table-name";
            final String stringValue ="some-string-value";
            GetItemRequest getItemRequest = new GetItemRequest().withTableName(tableName.toString())
             .withAttributesToGet(Arrays.asList("attr1","attr2","attr3","attr4"));
            getItemRequest.addKeyEntry(new String("attrName"), new AttributeValue().withS(stringValue));
            System.exit(0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.err.println(USAGE);
            System.exit(1);
        }
    }
}

$ javac -cp lib/aws-java-sdk-1.8.6.jar src/sw/Question.java
$ echo $?
0
$