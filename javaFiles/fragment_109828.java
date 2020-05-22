public class Light implements Switchable{
   private boolean on;

   @Override
   public boolean isOn() { return on; }

   @Override
   public void setIsOn(boolean on) { this.on = on; }       
}


public class LightSwitch {

    public void List<Switchable> switchables = new ArrayList<Switchable>(); // A generic list of things that are controlled by the switch. Doesn't have to be lights.

    public void off() { setState(false); }

    public void on() { setState(true); }

    private void setState(boolean state) {
       for(Switchable switchable: switchables) {
           switchable.setIsOn(state);
       }
    }
}