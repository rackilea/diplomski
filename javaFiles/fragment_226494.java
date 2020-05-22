private Boolean german;
    public SpeechletResponse onIntent(IntentRequest intentRequest, Session session) {
        if (intentRequest.getLocale().getLanguage().equals(new Locale("de").getLanguage())){
            System.out.println("Spoken language == Deutsch");
            german=true;
        }else{
            System.out.println("Spoken language == Englisch");
            german=false;
        }
...
}