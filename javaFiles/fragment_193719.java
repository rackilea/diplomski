for(Iterator<TruckRequirement> iterator1 = oldTruckRequirementSet.iterator(); iterator1.hasNext();){
    TruckRequirement oldTruckRequirement1 = iterator1.next();
    if(oldTruckRequirement1.getTruckClassName().equals(newTruckRequirement.getTruckClassName())) {
        LogUtil.logInfo("Truck Requirement Changed ", 
                "Truck Requirement Changed : From : {0} to {1} where Truck Class is: {2}",
                new Object[]{oldTruckRequirement1.getNumberOfTrucks(), 
                newTruckRequirement.getNumberOfTrucks(), newTruckRequirement.getTruckClassName()});

        // Use the iterator to remove
        iterator1.remove();
    }
}