public class SubRenderPanel extends RenderPanel{
   @Override
   public abstract void render()
   {
       //Do your stuff here
   }
}

public class Window implements Runnable{
    RenderPanel r = new SubRenderPanel();
    public void run(){
        while(running){

            r.render();
            Thread.sleep(5000);
        }
    }
}