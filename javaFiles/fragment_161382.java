Single
    .zip(
        Single.timer(1, TimeUnit.SECONDS), 
        userManager.loadConfig(),
        (time, config) -> config
    )
    .subscribe(
        config -> {
            applyConfig(config);
            launchActivity(HomeActivity.class);
        }, error -> {
            //some error handling
        }
     );