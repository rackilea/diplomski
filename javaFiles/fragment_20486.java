import java.io.*;
import java.util.*;
import org.apache.commons.digester.*;

public class DigestToMap {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        File file = new File("digestme.xml");
        Digester digester = new Digester();
        digester.setRules(new ExtendedBaseRules());
        digester.addObjectCreate("data", HashMap.class);
        digester.addRule("data/?", new Rule() {
            @Override public void end(String nspace, String name) {
                ((HashMap<String,String>)getDigester().peek()).put("[ID]", name);
            }
        });
        digester.addRule("*", new Rule() {
            @Override public void body(String nspace, String name, String text) {
                ((HashMap<String,String>)getDigester().peek()).put(name, text);
            }
        });
        Map<String,String> map = (Map<String,String>) digester.parse(file);
        System.out.println(map);
    }
}