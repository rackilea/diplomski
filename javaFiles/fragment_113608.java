$ mongo
MongoDB shell version: 2.2.0
connecting to: test
> db.printShardingStatus
function (verbose) {
    printShardingStatus(this.getSiblingDB("config"), verbose);
}