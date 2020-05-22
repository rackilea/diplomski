@Provides
@Singleton
Navigator providesNavigator(ActivityNavigator activityNavigator) {
    return activityNavigator; // singleton ActivityNavigator!
}

@Provides
@Singleton
SomeThingElse providesSomethingElse(ActivityNavigator activityNavigator) {
    return activityNavigator; // the same ActivityNavigator!
}