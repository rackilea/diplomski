import java.net.UnknownHostException;

import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import com.jacob.activeX.ActiveXComponent;

class TestMacroInvocation
{
    public static void main( String [] args ) throws Exception
    {
        ActiveXComponent catia = new ActiveXComponent("CATIA.Application");
        catia.setProperty("Visible", new Variant(true));
        Dispatch oDocuments = catia.getProperty("Documents").toDispatch();
        Dispatch oDocument = Dispatch.call(oDocuments, "Open", "C:\\Users\\Me\\Desktop\\TestRib.CATPart").toDispatch();

        Dispatch.call(catia, "StartCommand", "MyMacro");
        Dispatch.call(catia, "Quit");
    }