for (Integer provNetCycleId : provNetInfo) {
    this.provNetLocPs = jdbcShell.getJdbcConnection().prepareStatement(this.provNetLocQuery);
    this.provNetLocPs.setString(1,  tin);
    this.provNetLocPs.setInt(2,  provNetCycleId);
    this.provNetLocRs = this.provNetLocPs.executeQuery();

    while(this.provNetLocRs.next()){
        // because I create the map in the inner loop, I'll be loading each
        // result into a new map. When it was declared outside the loop, we 
        // kept referencing the same map instance and thus were overwriting it
        Map<String, Object> provData = new HashMap<String, Object>();


        provData.put("netCycleStartDate", provNetLocRs.getDate("netCycleStartDate"));
        provData.put("netCycleEndDate", provNetLocRs.getDate("netCycleEndDate"));
        provData.put("netLocCycleId", provNetLocRs.getInt("netLocCycleId"));
        provData.put("netLocCycStartDate", provNetLocRs.getDate("netLocCycStartDate"));
        provData.put("netLocCycleEndDate", provNetLocRs.getDate("netLocCycleEndDate"));
        provData.put("locId", provNetLocRs.getInt("locId"));
        provData.put("locStartDate", provNetLocRs.getDate("locStartDate"));
        provData.put("locEndDate", provNetLocRs.getDate("locEndDate"));
        provData.put("provId", provNetLocRs.getInt("provId"));

        System.out.println("HashCode "+provData.hashCode());
        provNetAndNetLoc.put(provNetCycleId, provData);


    }