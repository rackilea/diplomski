public void getHelp(HelpCallback callback){
        helpStrategy.getHelp(); // perform logic / behavior; "do something" as some might say
        if(callback != null) {
            callback.call(); // invoke the callback, to notify the caller of something
        }
    }