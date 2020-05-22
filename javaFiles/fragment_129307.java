import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException; 
import java.io.File; 

import javax.swing.*;

import org.mozilla.xpcom.*; 
import org.mozilla.interfaces.*;

/*
Websites ref
http://groups.google.com/group/mozilla.dev.tech.java/browse_thread/thread/898ba6751d0c57f7 
http://skrul.com/blog/code/
http://wirestorm.net/blog/?cat=9

*/


public class BrowserTest  implements nsIWebProgressListener,nsIWeakReference, nsIInterfaceRequestor, nsIWebBrowserChrome, nsISHistoryListener{ 
    static {
        try {
            System.loadLibrary("NativeWindow");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("can't find your library");
        }
    }
    private static final String frameTitle="GRE Embedded";
    public static void main(String[] args) {
        BrowserConroller controler=new BrowserConroller();
        controler.run();
        new BrowserTest().start();
    } 

    public void start(){


        JFrame f = new JFrame( frameTitle );
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 150);
        Container content = f.getContentPane();
        content.setBackground(Color.white);
        content.setLayout(new FlowLayout()); 
        content.add(new JLabel("Initializing ... "));
        f.setVisible(true);

        File grePath = null; 
        LocationProvider locProvider; 
        Mozilla mozilla = Mozilla.getInstance(); 

        GREVersionRange[] range = new GREVersionRange[1]; 
        range[0] = new GREVersionRange("1.8.0", true, "1.9", false); 

        try { 
            grePath = Mozilla.getGREPathWithProperties(range, null);
            mozilla.initialize(grePath);
            locProvider = new LocationProvider(grePath); 
            mozilla.initEmbedding(grePath, grePath, locProvider); 
        } 

        catch (FileNotFoundException e) { 
            System.out.println("Error: FileNotFoundException"); 
        } 
        catch (XPCOMException e) { 
            System.out.println("Error: XPCOMException"); 
        } 


        //---------- END GRE INITIALIZATION------------


        nsIServiceManager serviceManager = mozilla.getServiceManager(); 

        nsIAppStartup appStartup = (nsIAppStartup)serviceManager.getServiceByContractID("@mozilla.org/toolkit/app-startup;1", nsIAppStartup.NS_IAPPSTARTUP_IID); 
        nsIWindowCreator windowCreator = (nsIWindowCreator)appStartup.queryInterface(nsIWindowCreator.NS_IWINDOWCREATOR_IID); 

        nsIWindowWatcher windowWatcher =(nsIWindowWatcher)serviceManager.getServiceByContractID("@mozilla.org/embedcomp/window-watcher;1",nsIWindowWatcher.NS_IWINDOWWATCHER_IID); 

        windowWatcher.setWindowCreator(windowCreator); 

        nsIDOMWindow win = windowWatcher.openWindow(null, "http://google.com", "MAIN_WIN","chrome,resizable,centerscreen", null);
        windowWatcher.setActiveWindow( win ); 

        nsIComponentManager componentManager = mozilla.getComponentManager();
        String NS_IWEBBROWSER_CID = "F1EAC761-87E9-11d3-AF80-00A024FFC08C"; //$NON-NLS-1$
        nsIWebBrowser webBrowser = (nsIWebBrowser) componentManager.createInstance(NS_IWEBBROWSER_CID, null, nsIWebBrowser.NS_IWEBBROWSER_IID);
        webBrowser.setContainerWindow(this);
        webBrowser.addWebBrowserListener(this, nsIWebProgressListener.NS_IWEBPROGRESSLISTENER_IID);


//      nsIWebNavigation webNavigation=(nsIWebNavigation)webBrowser.queryInterface(nsIWebNavigation.NS_IWEBNAVIGATION_IID);
//      webNavigation.loadURI("http://www.zdnet.com", nsIWebNavigation.LOAD_FLAGS_NONE, null, null, null);
//      

        nsIBaseWindow baseWindow = (nsIBaseWindow) webBrowser.queryInterface(nsIBaseWindow.NS_IBASEWINDOW_IID);             
        long handle=FindWindow.getHWND( frameTitle );

        baseWindow.initWindow(handle, 0, 0, 0,350,350);
        baseWindow.create();
        baseWindow.setVisibility(true);




//      
//      nsIDOMWindow domWin=webBrowser.getContentDOMWindow();
//      nsIDOMEventTarget domEventTarget= (nsIDOMEventTarget)domWin.queryInterface(nsIDOMEventTarget.NS_IDOMEVENTTARGET_IID);
//      domEventTarget.addEventListener("click", new EventListener(), false);
//      
        //Hide JFrame after it have been initialized
        f.setVisible(true);
//      
//      nsIWebNavigation webNavigation=(nsIWebNavigation)webBrowser.queryInterface(nsIWebNavigation.NS_IWEBNAVIGATION_IID);
//      webNavigation.loadURI("http://www.zdnet.com", nsIWebNavigation.LOAD_FLAGS_NONE, null, null, null);
//      
        appStartup.run(); 
        System.out.println("try termEmbedding"); 
        try { 
            System.out.println("mozilla.termEmbedding(); START"); 
            mozilla.termEmbedding(); 
            System.out.println("mozilla.termEmbedding(); FINISHED"); 
        } 
        catch (XPCOMException e) { 
            System.out.println("Fehler: XPCOMException"); 
        } 
        System.out.println("finished termEmbedding"); 
        System.out.println("All done"); 
    }



    public void onLocationChange(nsIWebProgress webProgress, nsIRequest request, nsIURI location) {
        c("onLocationChange");

    }

    public void onProgressChange(nsIWebProgress webProgress, nsIRequest request, int curSelfProgress, int maxSelfProgress, int curTotalProgress, int maxTotalProgress) {
        c("onProgressChange");

    }

    public void onSecurityChange(nsIWebProgress webProgress, nsIRequest request, long state) {
        c("onSecurityChange");

    }

    public void onStateChange(nsIWebProgress webProgress, nsIRequest request, long stateFlags, long status) {
        c("onStateChange");

    }

    public void onStatusChange(nsIWebProgress webProgress, nsIRequest request, long status, String message) {
        c("onStatusChange");

    }

    public nsISupports queryInterface(String uuid) {
        c("queryInterface");
        return null;
    }



    public nsISupports queryReferent(String uuid) {
        c("queryReferent");
        return null;
    }

    public nsISupports getInterface(String uuid) {
        c("getInterface");
        return null;
    }
    private void c(Object o){
        System.out.println(o);
    }

    public void destroyBrowserWindow() {
        c("destroyBrowserWindow");

    }

    public void exitModalEventLoop(long status) {
        c("exitModalEventLoop");

    }

    public long getChromeFlags() {
        c("getChromeFlags");
        return 0;
    }

    public nsIWebBrowser getWebBrowser() {
        c("getWebBrowser");     
        return null;
    }

    public boolean isWindowModal() {
        c("isWindowModal");     
        return false;
    }

    public void setChromeFlags(long chromeFlags) {
        c("setChromeFlags");    

    }

    public void setStatus(long statusType, String status) {
        c("setStatus"); 

    }

    public void setWebBrowser(nsIWebBrowser webBrowser) {
        c("setWebBrowser");         
    }

    public void showAsModal() {
        c("showAsModal");   

    }

    public void sizeBrowserTo(int acx, int acy) {
        c("sizeBrowserTo"); 

    }

    public boolean onHistoryGoBack(nsIURI backURI) {
        c("onHistoryGoBack");
        return false;
    }

    public boolean onHistoryGoForward(nsIURI forwardURI) {
        c("onHistoryGoForward");
        return false;
    }

    public boolean onHistoryGotoIndex(int index, nsIURI gotoURI) {
        c(" onHistoryGotoIndex");
        return false;
    }

    public void onHistoryNewEntry(nsIURI newURI) {
        c(" onHistoryNewEntry");
    }

    public boolean onHistoryPurge(int numEntries) {
        c(" onHistoryPurge");
        return false;
    }

    public boolean onHistoryReload(nsIURI reloadURI, long reloadFlags) {
        c(" onHistoryReload");
        return false;
    }


} //public class JavaXPCOM_test1[/code]