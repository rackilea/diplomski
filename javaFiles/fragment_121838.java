class Test100 extends JFrame implements ActionListener {

    //...     

    public static JMenuItem fontApp, imageApp = new JMenuItem();  // fields -- never added to GUI

    //.... 


    //Method - menuBuilder - A method to build JMenus
    public void menuBuilder()
    {
        // ....

        //  *** re-declaring the variables here!! *** these are different variables and hold 
        // different objects
        JMenuItem fontApp = new JMenuItem( "Font App" );
        apps.add ( fontApp ); //Add Menu items to our JMenu

        //Add JMenu Item
        JMenuItem imageApp = new JMenuItem( "Image App" );
        apps.add ( imageApp ); //Add Menu items to our JMenu

        // ......

    }