public static void main(String[] args) 
{
    EventQueue.invokeLater(new Runnable() { public void run() {
        GUI gui = new GUI();
        gui.loadGrid(args[0]);
    }});
}