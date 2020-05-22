import java.util.Vector;

import javax.microedition.io.*;
import net.rim.device.api.ui.*;
import net.rim.device.api.ui.component.*;
import net.rim.device.api.ui.container.*;
import net.rim.device.api.system.*;
import net.rim.device.api.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

class XML_Parsing_Sample extends UiApplication{
    //creating a member variable for the MainScreen
    MainScreen _screen= new MainScreen();
    //string variables to store the values of the XML document
    String _node,_element;
    Connection _connectionthread;

    public static void main(String arg[]){
        XML_Parsing_Sample application = new XML_Parsing_Sample();
        //create a new instance of the application
        //and start the application on the event thread
        application.enterEventDispatcher();
    }

    public XML_Parsing_Sample() {

        UiApplication.getUiApplication().invokeLater(new Runnable() {
            public void run() {
                UiApplication.getUiApplication().pushScreen(new LoadingScreen());
            }
        });


       // pushScreen(_screen); // creating a screen
        //creating a connection thread to run in the background
        _connectionthread = new Connection();
        _connectionthread.start();//starting the thread operation
    }

    public void pushingToNextScreen(final Vector node,final Vector elem){
        UiApplication.getUiApplication().invokeLater(new Runnable() {
            public void run() {
                 UiApplication.getUiApplication().popScreen(UiApplication.getUiApplication().getActiveScreen());
                 UiApplication.getUiApplication().pushScreen(new datascreen(node, elem));//after last element it will call mainscreen constructer
            }
        });
    }

  class datascreen extends MainScreen
  {
      public datascreen(Vector node,Vector elem) {
        //you can write your logic and design with data(vectors contain all data)
    }
  }