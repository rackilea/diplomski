private static List<ScreenProvider> screenProviders = screenProviders();

public static Screen getNextScreen(JSONObject jsonObject) {
    for (ScreenProvider screenProvider : screenProviders) {
        if (screenProvider.supports(jsonObject)) {
            return screenProvider.getScreen(jsonObject);
        }
    }
    return null;
}

interface ScreenProvider {
    boolean supports(JSONObject jsonObject);
    Screen getScreen(JSONObject jsonObject);
}

private static List<ScreenProvider> screenProviders() {
    return Arrays.asList(
            new ScreenProvider() {
                public boolean supports(JSONObject jsonObject) {
                    return isNextProgramScreen(jsonObject);
                }

                public Screen getScreen(JSONObject jsonObject) {
                    ParentRatingsObject parentRatingsObject = JsonBusinessObjectFactory.createParentRatingsObject(jsonObject);
                    return new NextProgramScreen(parentRatingsObject);
                }
            },
            new ScreenProvider() {
                public boolean supports(JSONObject jsonObject) {
                    return isTimerScreen(jsonObject);
                }

                public Screen getScreen(JSONObject jsonObject) {
                    ChildWithParentRatingsObject childWithParentRatingsObject = JsonBusinessObjectFactory.createChildWithParentRatingsObject(jsonObject);
                    return new TimerScreen(childWithParentRatingsObject);
                }
            },
            new ScreenProvider() {
                public boolean supports(JSONObject jsonObject) {
                    return isNextContestantPreJudgeScreen(jsonObject);
                }

                public Screen getScreen(JSONObject jsonObject) {
                    ChildWithParentRatingsObject childWithParentRatingsObject = JsonBusinessObjectFactory.createChildWithParentRatingsObject(jsonObject);
                    return new NextContestantPreJudgingScreen(childWithParentRatingsObject);
                }
            },
            new ScreenProvider() {
                public boolean supports(JSONObject jsonObject) {
                    return isNextContestantJudgeScreen(jsonObject);
                }

                public Screen getScreen(JSONObject jsonObject) {
                    ChildWithParentRatingsObject childWithParentRatingsObject = JsonBusinessObjectFactory.createChildWithParentRatingsObject(jsonObject);
                    return new TimerScreen(childWithParentRatingsObject);
                }
            }
    );
}