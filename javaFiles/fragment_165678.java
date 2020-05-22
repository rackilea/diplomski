formTester.setValue("path","");

AbstractAutoCompleteBehavior behavior = (AbstractAutoCompleteBehavior)
WicketTesterHelper.findBehavior(wicketTester.getComponentFromLastRenderedPage("path"),
AbstractAutoCompleteBehavior.class);
wicketTester.executeBehavior(behavior);