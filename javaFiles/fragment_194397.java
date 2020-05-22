protected Object clone(){
    Game obj = new Game(getTitle(), 
                        new Person(getLeadVoiceActor().getFirstName(), getLeadVoiceActor().getLastName()), 
                        getRating());
    return obj;
}