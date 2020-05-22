import java.applet.Applet;
import java.awt.*;
import netscape.javascript.JSObject;

public class Test extends Applet {
  public void init() {
    JSObject window = JSObject.getWindow(this); // this=applet
    String[] params = {"blah", "cool"};
    Object ret = window.call("testfunc", params);
    if (ret instanceof JSObject){
      JSObject jsret = (JSObject)ret;
      Object len = jsret.getMember("length");
      String val = "";
      if (len instanceof Number){
        val = "array: ";
        int n = ((Number)len).intValue();
        for (int i = 0; i < n; ++i){
            val += jsret.getSlot(i).toString() + " ";
        }
      } else{
        val = "no array: " + ret.toString();
      }
      String[] params2 = {val};
      window.call("alert", params2);
    } else{
      String[] params2 = {ret.toString()};
      window.call("alert", params2);
    }
  }
}