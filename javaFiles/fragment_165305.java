while (mRunning) {
                    Canvas c = null;
                    try {
          //mistake was here
                        c = mHolder.lockCanvas();
                        synchronized (mHolder) {

                            if (c != null) {
                             //do stuff
                            }
                        }
                    }