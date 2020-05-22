import com.sun.javafx.runtime.Entry;
Entry.deferAction( new Runnable() {
                    @Override
                    public void run() {
                        fxListener.onMessage(copy);
                    }
                } );