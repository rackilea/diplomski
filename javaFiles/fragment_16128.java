public interface Observer
{ 
   public void update(KeyEvent keyEvent);
}

public interface Observable
{
   public void NotifyObservers(KeyEvent keyEvent);
}

public class World implements KeyListener, Observable
{
   private ArrayList<Observer> obsList;

   public World()
   {
      obsList = new ArrayList();
   }

   public void keyPressed(KeyEvent e) 
   {
      NotifyObservers(e);
   }

   public void keyReleased(KeyEvent e) {}
   public void keyTyped(KeyEvent e) {}

   public void NotifyObservers(KeyEvent keyEvent)
   {
       for(Observer obs : obsList)
       {
           obs.update(keyEvent);
       }
   }

   public void AddObserver(Observer obs)
   {
       if (obs != null)
          obsList.add(obs);
   }

   public void DelObserver(Observer obs)
   {
       if (obs != null)
          obsList.remove(obs);
   }
}

public class Blobs extends JFrame implements Observer
{

    public Blobs() 
    {
        super("Blobs :) - By Chris Tanaka");

        //Register this instance of Blobs as an observer that is stored in the World's
        //obsList ArrayList field
        World world = new World();
        world.addObserver(this);

        setResizable(false);
        setSize(1000, 1000);
        setIgnoreRepaint(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(world);
        this.addKeyListener(world);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Blobs();
    }

    public void update(KeyEvent keyEvent)
    {
       //do whatever here when key event occurs
    }
}