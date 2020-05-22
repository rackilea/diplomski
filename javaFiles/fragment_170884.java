ScenarioStuff{
private String Name;
private Boolean happy;

private Object readResolve() {
        if(happy == null){
            happy = true;
        }
        return this;
  }
}