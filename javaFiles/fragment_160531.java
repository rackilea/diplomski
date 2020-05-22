public void onClick(View v) {
        final Docket docket = docketInstance;
        Runnable target = new Runnable(){
            public void run() {
                // do your stuff with the docket
                System.out.println(docket);
            }
        };
        new Thread(target).start();

    }