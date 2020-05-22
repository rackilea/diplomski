public class ServerClass extends Thread
{
    // all the fields you need. minus the List<Player>.

    public ServerClass(Game game, Socket s)
    {
        super("NewPlayer");

        g = game;  // g is the name that you used. consider changing it to a better name.

        // continue initialization as normal.
        // you do not need the key

        game.createNewPlayer(s);
    }

    // at the run method.
    public void run()
    {
        //start as usual...

        else 
        {
            out.writeUTF("Give me your name");
            name2 = in.readUTF();
            currid2 = g.getID2();
            Player player = game.getPlayer(currid2);
            if(null != player)
            {
                player.setName(name2);
            }

            ft = false;
        }

        // continue as usual...
    }
}