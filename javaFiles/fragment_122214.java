public void achieve(final String awardId) {
    ScoreloopManagerSingleton.get().loadAchievements(null);

    // final String awardId = context.getResources().getString(resId);

    // i.e. wait with the unlocking and/or display of achievements until your runnable gets invoked.
    ScoreloopManagerSingleton.get().loadAchievements(new Continuation<Boolean>() {
      @Override
      public void withValue(Boolean arg0, Exception arg1) {
        Achievement achivment = ScoreloopManagerSingleton.get().getAchievement(awardId);
        if (achivment.getAward().getAchievingValue() - achivment.getValue() == 1) {
          ScoreloopManagerSingleton.get().achieveAward(achivment.getAward().getIdentifier(), true, true);
        } else {
          if (!achivment.isAchieved()) {
            achivment.incrementValue();
          }

          if (achivment.needsSubmit()) {
            AchievementController aController = new AchievementController(
                new RequestControllerObserver() {

                  public void requestControllerDidReceiveResponse(RequestController arg0) {
                    // TODO Auto-generated method stub

                  }

                  public void requestControllerDidFail(RequestController arg0, Exception arg1) {
                    // TODO Auto-generated method stub

                  }
                });

            aController.setAchievement(achivment);
            aController.submitAchievement();
          }
        }
      }

    });
  }