public void onViewLoad(boolean hideLocks) {
    Observable.just(settingsRatingRepository.getRatingsFromDB())
            .flatMap(settingsRatings -> {
                if (settingsRatings.isEmpty()) {
                    return settingsRatingRepository.getSettingsRatingModules();
                } else {
                    return Observable.just(settingsRatings);
                }
            })
            .compose(schedulerProvider.getSchedulers())
            .subscribe(ratingsList -> {
                view.loadRatingLevels(ratingsList, hideLocks);
            }, this::handleError);
}