private Timer recalculateTimer = new Timer( 20, myRecalculateActionListener );

constructor(){
  recalculateTimer.setRepeats( false );
}
@Override
public void componentResized(ComponentEvent e){
  if ( recalculateTimer.isRunning() ){
    recalculateTimer.restart();
  } else {
    recalculateTimer.start();
  }
}