import java.io.InputStream;
import java.io.OutputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import net.rim.blackberry.api.browser.URLEncodedPostData;
import net.rim.device.api.io.http.HttpProtocolConstants;

public class HttpPostSample {
    HttpConnection hc = null;
    StringBuffer stringBuffer = new StringBuffer();
    InputStream inputStream;

    public HttpPostSample(String url) {
        try{
            hc = (HttpConnection)Connector.open(url+";interface=wifi");//you have to use connection extension ";interface=wifi" this is only for wifi 
            URLEncodedPostData oPostData = new URLEncodedPostData(URLEncodedPostData.DEFAULT_CHARSET, false);
            //These are your appending values and tags 
            oPostData.append("property_id","value");
            oPostData.append("property_name","value");
            oPostData.append("category","value");
            oPostData.append("address","value");
            oPostData.append("country","value");
            hc.setRequestMethod(HttpConnection.POST);
            hc.setRequestProperty(HttpProtocolConstants.HEADER_CONTENT_TYPE, oPostData.getContentType());
            byte [] postBytes = oPostData.getBytes();
            hc.setRequestProperty(HttpProtocolConstants.HEADER_CONTENT_LENGTH, Integer.toString(postBytes.length));
            OutputStream strmOut = hc.openOutputStream();
            strmOut.write(postBytes);
            strmOut.flush();
            strmOut.close();

            String returnMessage = hc.getResponseMessage();
            System.out.println("============"+returnMessage);
            if(hc.getResponseCode()==HttpConnection.HTTP_OK)
            {
                inputStream = hc.openInputStream();
                int c;
                while((c=inputStream.read())!=-1)
                {
                    stringBuffer.append((char)c);
                }
                System.out.println(">>>>>>>>>>>>>>>>>"+stringBuffer.toString());
                parseResults(stringBuffer.toString());

            }else{
                parseResults("ERROR");
            }


        }catch (Exception e) {
            // TODO: handle exception
        }
    }
    private void parseResults(String response)
    {
        if(response.equalsIgnoreCase("ERROR"))
        {
            System.out.println("Error in Connection please check your internet and Connection extension");
        }else{
            System.out.println(response);
        }
    }

}