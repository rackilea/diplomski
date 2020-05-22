target.getPage().visitChildren(FeedbackPanel.class, new IVisitor<FeedbackPanel, Void>() {
    @Override
    public void component(FeedbackPanel component, IVisit<Void> visit) {
        if (component.isVisibleInHierarchy() && component.anyMessage()) {
            target.add(component);
        }
    }
});