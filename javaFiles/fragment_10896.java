showAnimation = new Thread(new Runnable() {

            @Override
            public void run() {
                while(true){
                    synchronized (this) {
                        try {                       
                            Thread.sleep(100);
                            Display.getDefault().asyncExec(new Runnable() {                             
                                @Override
                                public void run() {
                                    table.addPaintListener(paint);
                                    table.redraw();
                                    table.update();
                                    table.removePaintListener(paint);
                                }
                            });

                        } 
                        catch (InterruptedException e) 
                        {
                            // do nothing, because this thread is meant to be interrupted!
                            // and then, break out of the infinite loop
                            break;
                        }
                    }                   
                }                               
            }
        });