import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.axiom.util.base64.Base64Utils;

public class JWTAssertionReader {

    public static String signedJWTToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJTSEEyNTZ3aXRoUlNBIiwieDV0IjoiTm1KbU9HVXhNelpsWWpNMlpEUmhOVFpsWVRBMVl6ZGhaVFJpT1dFME5XSTJNMkptT1RjMVpBPT0ifQ==.eyJpc3MiOiJ3c28yLm9yZy9wcm9kdWN0cy9hbSIsImV4cCI6MTM3MjUyMjgwNTE3NywiaHR0cDovL3dzbzIub3JnL2NsYWltcy9zdWJzY3JpYmVyIjoibGFsYWppIiwiaHR0cDovL3dzbzIub3JnL2NsYWltcy9hcHBsaWNhdGlvbmlkIjoiMSIsImh0dHA6Ly93c28yLm9yZy9jbGFpbXMvYXBwbGljYXRpb25uYW1lIjoiRGVmYXVsdEFwcGxpY2F0aW9uIiwiaHR0cDovL3dzbzIub3JnL2NsYWltcy9hcHBsaWNhdGlvbnRpZXIiOiJVbmxpbWl0ZWQiLCJodHRwOi8vd3NvMi5vcmcvY2xhaW1zL2FwaWNvbnRleHQiOiIvYXBpMSIsImh0dHA6Ly93c28yLm9yZy9jbGFpbXMvdmVyc2lvbiI6IjEuMi4zIiwiaHR0cDovL3dzbzIub3JnL2NsYWltcy90aWVyIjoiVW5saW1pdGVkIiwiaHR0cDovL3dzbzIub3JnL2NsYWltcy9rZXl0eXBlIjoiUFJPRFVDVElPTiIsImh0dHA6Ly93c28yLm9yZy9jbGFpbXMvdXNlcnR5cGUiOiJBUFBMSUNBVElPTiIsImh0dHA6Ly93c28yLm9yZy9jbGFpbXMvZW5kdXNlciI6ImxhbGFqaSIsImh0dHA6Ly93c28yLm9yZy9jbGFpbXMvZW5kdXNlclRlbmFudElkIjoiLTEyMzQifQ==.YtVaDtRYtfUkVDvwe9V8oqsXK8OkB4HUhsQS2z3ngWRNjAktSKWlH+Is9T5EQnsg8hrsJQ4nKDdwDWHAUIFxIsb7bX/Y1O+WSLMLZYQ11WVzFaw50BJuqPbL9ZOfux1iRnm4ZbxClVSan72g/w8a05UnCvsGyIh5oCP4RUsAhXo=";

    public static void main(String[] args) {
        String[] split_string = signedJWTToken.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];
        String base64EncodedSignature = split_string[2];

        String decodedHeader = new String(Base64Utils.decode(base64EncodedHeader));
        System.out.println("Decoded Header :");
        System.out.println("===========================");
        System.out.println(decodedHeader);


        System.out.println("Decoded Body :");
        System.out.println("============================");
        String decodedBody = new String(Base64Utils.decode(base64EncodedBody));
        System.out.println(decodedBody);

        // I am not too sure you will not be getting Signature without the use of .keystore
        // Below code will not works, just will give hints / guidelines
        System.out.println("Decoded Signature :");
        System.out.println("==================");
        byte[] decodedSignature = Base64Utils.decode(base64EncodedSignature);
        Pattern pattern = Pattern.compile("^[^:]*:[^:]*:[^:]*:\"(.+)\"}$");
        Matcher matcher = pattern.matcher(decodedHeader);
        String base64EncodedCertThumb = null;
        if(matcher.find()){
            base64EncodedCertThumb = matcher.group(1);
        }
        byte[] decodedCertThumb = Base64Utils.decode(base64EncodedCertThumb);
        System.out.println(decodedCertThumb);
    }
}