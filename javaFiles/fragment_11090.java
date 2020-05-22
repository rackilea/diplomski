boolean filterContainsName = itemFilter.contains(event.getItem().getName());
boolean useBlacklist       = config.get("filterMode").equals("blacklist");
boolean useWhitelist       = config.get("filterMode").equals("whitelist");

if (!config.get("safeMode") || event.isSafe()) {
    if((!useBlackList && !useWhiteList) ||
       ( useWhiteList &&  filterContainsName) ||
       ( useBlackList && !filterContainsName)) {
        item.process();
    }
}