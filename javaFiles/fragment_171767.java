final ComponentMatcher matcher = new TypeMatcher(myTreeTable.class);

Pause.pause(new Condition("Waiting for myTreeTable") {
    @Override
    public boolean test() {
        Collection<Component> list = 
                window.robot.finder().findAll(window.target, matcher);
        return list.size() > 0;
    }
 }, 5000);