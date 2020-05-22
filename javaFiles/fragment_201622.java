new Thread(new Runnable(){void run(){
    // draw all the ovals on canvas
    context.runOnUiThread(new Runnable(){void run(){
        // this will be executed in main thread when drawing finishes
    }});
}}).start();