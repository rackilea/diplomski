import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SwingOutputStream extends ByteArrayOutputStream{
  private final ISwingLogger fSwingLogger;

  private Timer fTimer;
  private final StringBuilder fBuffer = new StringBuilder( 1000 );

  public SwingOutputStream( ISwingLogger aSwingLogger ) {
    fSwingLogger = aSwingLogger;

    fTimer = new Timer( 200, new ActionListener() {
      public void actionPerformed( ActionEvent aActionEvent ) {
        flushBuffer();
      }
    } );
    fTimer.setRepeats( false );
  }

  @Override
  public void flush() throws IOException {
    synchronized( fBuffer ){
      fBuffer.append( toString( "UTF-8") );
    }
    if ( fTimer.isRunning() ){
      fTimer.restart();
    } else {
      fTimer.start();
    }

    super.flush();
    reset();
  }

  private void flushBuffer(){
    synchronized ( fBuffer ){
      final String output = fBuffer.toString();
      fSwingLogger.appendString( output );
      fBuffer.setLength( 0 );
    }
  }
}