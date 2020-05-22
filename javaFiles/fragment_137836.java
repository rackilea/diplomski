import com.kirillch.constants.PravoRuConstants;
import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class PravoRuPasswordHandler implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
        pc.setPassword(PravoRuConstants.PASSWORD);


        //      for(int i=0; i<callbacks.length; i++) {
        //          WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];
        //          if(pc.getIdentifier().equals(PravoRuConstants.USERNAME)){
        //              pc.setPassword(PravoRuConstants.PASSWORD);
        //              return;
        //          }
        //      }

    }
}