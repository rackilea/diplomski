import javax.swing.*;

public class MenuApplet extends JApplet{

    public void init(){
        JMenuBar menubar = new JMenuBar();

        JMenu menuOption = new JMenu("Option");

        JMenuItem NewGame = new JMenuItem("New Game");
        menuOption.add(NewGame);

        JMenuItem exitGame = new JMenuItem("Exit Game");
        menuOption.add(exitGame);

        JMenu menuLevel = new JMenu("Level");

        JMenuItem levelOne = new JMenuItem("Level One");
        JMenuItem levelTwo = new JMenuItem("Level Two");
        JMenuItem levelThree = new JMenuItem("Level Three");

        // the menu items, menus and menu bar all need
        // to be ADDED to something!
        menubar.add(menuOption);
        menuOption.add(NewGame);
        menuOption.add(exitGame);
        menubar.add(menuLevel);
        menuLevel.add(levelOne);
        menuLevel.add(levelTwo);
        menuLevel.add(levelThree);
        setJMenuBar(menubar);
    }
}