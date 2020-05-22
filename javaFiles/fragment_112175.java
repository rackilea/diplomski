private BooleanProperty isCompetitive = new SimpleBooleanProperty(true);
public void setIsCompetitive(boolean isCompetitive){
    this.isCompetitive.set(isCompetitive);
}
public boolean getIsCompetitive(){
    return this.isCompetitive.get(); 
}
public BooleanProperty isCompetitiveProperty() {
    return isCompetitive;
}