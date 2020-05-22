for(Handler handler: logger.getHandlers()){
    if(handler instanceof TextAreaHandler){
        TextAreaHandler textAreaHandler = (TextAreaHandler) handler;
        getContentPane().add(textAreaHandler.getTextArea());
    }
}