import javax.swing.*;

/*
<applet code=DialerApplet width=250 height=70>
<param name="servername" value="Evolution-X" >
<param name="ip"  value="127.0.0.1" >
<param name="port" value="43594" >
</applet>
*/
public class DialerApplet extends JApplet {
    public void init() {
        JTextArea ta = new JTextArea(20,5);
        add(new JScrollPane(ta));

        String eol = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        String[] params = {"servername","ip","port"};
        for (String param : params) {
            sb.append( param );
            sb.append( ": " );
            sb.append( getParameter(param) );
            sb.append( eol );
        }
        ta.setText(sb.toString());

        validate();
    }
}