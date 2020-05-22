public class MyChangeListener implements ChangeListener
{
  boolean animationMode = true;

  public void setAnimationMode( boolean mode )
  {
    this.mode = true;
  }

  @Override
  public void stateChanged(ChangeEvent arg0)
  {
    if ( !animationMode )
    {
      // do stuff
    }
  }
}