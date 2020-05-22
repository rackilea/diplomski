public class GraphicView extends SurfaceView implements Runnable {

    synchronized public boolean onTouchEvent( MotionEvent me ) {


        Log.d( "mutex", "ACTION 1" );

        switch ( action ) {

            case MotionEvent.ACTION_DOWN: {

                int rnd = new Random().nextInt( 40000 ) + 1000;
                for ( int i = 0; i < rnd; i++ ) {} // it's some long action :)

                Log.d( "mutex", "ACTION 2: down" );
                break;

            }

        }

        Log.d( "mutex", "ACTION 2: end" );

    }


    synchronized public void run() {

        while ( true ) {
            wait(100); // Wait 100ms and release the lock
            Log.d( "mutex", "!!! RUN !!!!" );

        }

    }

}