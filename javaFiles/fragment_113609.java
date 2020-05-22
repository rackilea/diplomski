> printShardingStatus
function (configDB, verbose) {
    if (configDB === undefined) {
        configDB = db.getSisterDB("config");
    }
    var version = configDB.getCollection("version").findOne();

    // ...
}