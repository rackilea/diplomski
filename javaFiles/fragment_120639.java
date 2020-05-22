AmazonRDSClient rdsClient = new AmazonRDSClient(/*add your credentials and the proper constructor overload*/);
rdsClient.setRegion(Region.getRegion(Regions.EU_CENTRAL_1));

CopyDBSnapshotRequest copySnapshot = new CopyDBSnapshotRequest();
copySnapshot.setSourceDBSnapshotIdentifier("arn:aws:rds:us-east-1:123456789012:snapshot:mysql-instance1-snapshot-20130805");
copySnapshot.setTargetDBSnapshotIdentifier("mysql-instance1-snapshot-20130805-copy");

DBSnapshot dbSnapshot = rdsClient.copyDBSnapshot(copySnapshot);