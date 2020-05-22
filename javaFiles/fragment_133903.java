// cluster starting up ...
2017-08-17 12:49:55,977 [main]  clusterOpening: 599582e36d47c231ec963b0b
2017-08-17 12:49:56,076 [cluster-ClusterId{value='599582e36d47c231ec963b0b', description='null'}-hostA:27017]   clusterDescriptionChanged: 599582e36d47c231ec963b0b
2017-08-17 12:49:56,076 [cluster-ClusterId{value='599582e36d47c231ec963b0b', description='null'}-hostB:27017]   clusterDescriptionChanged: 599582e36d47c231ec963b0b
2017-08-17 12:49:56,076 [cluster-ClusterId{value='599582e36d47c231ec963b0b', description='null'}-hostC:27017]   clusterDescriptionChanged: 599582e36d47c231ec963b0b
2017-08-17 12:49:56,076 [cluster-ClusterId{value='599582e36d47c231ec963b0b', description='null'}-hostA:27017]   clusterDescriptionChanged   599582e36d47c231ec963b0b
2017-08-17 12:49:56,076 [cluster-ClusterId{value='599582e36d47c231ec963b0b', description='null'}-hostA:27017]   REPLICA_SET_OTHER / hostB:27017 / CONNECTED / {}    
2017-08-17 12:49:56,077 [cluster-ClusterId{value='599582e36d47c231ec963b0b', description='null'}-hostA:27017]   REPLICA_SET_OTHER / hostC:27017 / CONNECTED / {}    
2017-08-17 12:49:56,077 [cluster-ClusterId{value='599582e36d47c231ec963b0b', description='null'}-hostA:27017]   REPLICA_SET_SECONDARY / hostA:27017 / CONNECTED / {}    
// ... the primary fails over to hostA:27017
2017-08-17 12:50:06,080 [cluster-ClusterId{value='599582e36d47c231ec963b0b', description='null'}-hostA:27017]   clusterDescriptionChanged:  599582e36d47c231ec963b0b
2017-08-17 12:50:06,080 [cluster-ClusterId{value='599582e36d47c231ec963b0b', description='null'}-hostA:27017]   REPLICA_SET_OTHER / hostB:27017 / CONNECTED / {}    
2017-08-17 12:50:06,080 [cluster-ClusterId{value='599582e36d47c231ec963b0b', description='null'}-hostA:27017]   REPLICA_SET_SECONDARY / hostC:27017 / CONNECTED / {}    
2017-08-17 12:50:06,080 [cluster-ClusterId{value='599582e36d47c231ec963b0b', description='null'}-hostA:27017]   REPLICA_SET_PRIMARY / hostA:27017 / CONNECTED / {}  
2017-08-17 12:50:07,126 [main]  clusterClosed: 599582e36d47c231ec963b0b