BEGIN TRANSACTION;
if (db.leaderID <= $leaderID) {
    db.leaderID = $leaderID;
    db.update($change);
}
END TRANSACTION;