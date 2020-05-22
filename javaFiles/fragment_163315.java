HashMap<String, Object> params = new HashMap<String, Object>();
params.put( "AID", adminId );
params.put( "CEID", currentEmployeeId );
params.put( "STime", startTime );
params.put( "ETime", endTime );

query.executeWithMap( params );