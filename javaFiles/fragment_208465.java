public void performOnWatch(WatcherConfig config, Consumer<WatchConfig> consumer) {
    config.streamWatchConfigs()
        .flatMap(WatchUtils::parseWatchParameters)
        .forEach(consumer::accept);
}

performOnWatch(config, this::deployWatch);
performOnWatch(config, this::deleteWatch);