package cdig;

import java.applet.Applet;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Base64;


/**
 *
 * @author Ulysses Marins 
 */
public class CDigApplet extends Applet
{

    private static final long serialVersionUID = 1L;

    String ret;

    CDigApplet applet = this;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public String signFile(String fileID, String pin, String token)
    {
        AccessController.doPrivileged(new PrivilegedAction()
        {
            @Override
            public Object run()
            {
                try
                {
                    File objFile = new File(token);

                    System.out.println("Iniciando processo de assinatura.");

                    objFile.sign("json", sig);

                        System.out.println(ret);
                    } else {
                        throw new IllegalArgumentException("Não foi possível iniciar processo de assinatura.");
                    }

                }
                catch (Exception e)
                {
                    String sl = "{\"success\":false," + "\"message\":\"" + e.getMessage() + "\"}";
                    ret = sl;
                    System.out.println(sl);
                }

                return null;
            }
        });

        return ret;
    }

    public void init(){
    }

    public void destroy(){
    }

}