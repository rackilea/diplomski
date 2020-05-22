final ComponentMatcher nameMatcher = new ComponentMatcher(){
    @Override
    public boolean matches(Component c) {
        return "ComponentName".equals(c.getName()) && c.isShowing();
    }
};

Pause.pause(new Condition("Waiting") {
    @Override
    public boolean test() {
        Collection<Component> list = 
                window.robot.finder().findAll(window.target, nameMatcher);
        return list.size() > 0;
    }
 }, 5000);