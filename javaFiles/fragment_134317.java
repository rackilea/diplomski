public class Mypage extends WebPage{

    ...

    private boolean behaviorAssigned = false;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onBeforeRender(){
        if(!behaviorAssigned){
            behaviorAssigned=true;
            visitChildren(new IVisitor<Component>(){

                @Override
                public Object component(Component component){
                    if(component instanceof AbstractTextComponent<?>){
                        component.add(new DontLeaveBehavior());
                    }
                    return null;
                }
            });
        }
        super.onBeforeRender();
    }

}