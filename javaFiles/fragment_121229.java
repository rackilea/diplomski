@Override
    public void renderHead( final IHeaderResponse response )
    {
 ...
                //use the `setupCallback` to store the callback script somewhere.., I store it in 'interactionurl'
        String script = String.format(  " setupCallback(this.interactionbehavior.getCallbackScript()); "); 
        response.render( OnDomReadyHeaderItem.forScript( script ) 
    }