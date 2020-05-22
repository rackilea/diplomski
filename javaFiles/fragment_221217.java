import javax.swing.JApplet;

import test.ThirdParty;

public class TestApplet extends JApplet{
    public void init(){
        this.setSize(400, 400);
        this.setVisible(true);

        ThirdParty tParty = new ThirdParty();
        System.out.println(tParty.hello());
    }

}