class MyKieBaseEventListener implements KieBaseEventListener {
    private int removedRules;
    public void afterRuleRemoved(AfterRuleRemovedEvent event){
        removedRules++;
    }
    public int getRemovedRules(){
        return removedRules;
    }
    // other methods
}