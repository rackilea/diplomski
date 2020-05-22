interface CoolThirdPartyListenerManager {
    public void addListenerForModel(CoolThirdPartyModel model, CoolThirdPartyModelListener listener);
    /*
     * return value should indicate success of operation, i.g. return false if no
     * listeners were added to model.
     * it can also throw some sort of exception, if it suits your needs better.
     */
    public boolean removeListenerFromModel(CoolThirdPartyModel model);
}