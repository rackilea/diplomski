pbds = new BoneCPDataSource();      
pbds.setDatasourceBean(mysqlcpds);
pbds.setMinConnectionsPerPartition(1);              
pbds.setMaxConnectionsPerPartition(10);    
pbds.setIdleConnectionTestPeriodInMinutes(60);
pbds.setIdleMaxAgeInMinutes(240);
pbds.setPartitionCount(1);