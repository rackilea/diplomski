public class HighscoreInzien {

    Mainframe mainFrame;

    public HighscoreInzien(Mainframe mainFrame) {
        this.mainFrame = mainFrame;
    }

    ...
}

public class HoofdmenuPaneel extends JPanel implements ActionListener {

    Mainframe mainFrame;
    public HoofdmenuPaneel(Mainframe mainFrame){
        this.mainFrame = mainFrame;
        ...
    }
}

public class Mainframe extends JFrame   {

    public  Mainframe(){
       ...

       HoofdmenuPaneel hoofdmenuPaneel = new HoofdmenuPaneel(this);
       ...
    }
}