public Set<WorkStation> getWorkstationsPerEmployee(final Employee employee){
    final Set<WorkStation> workStations = new HashSet<WorkStation>();
    for(final Binding binding : employee.getBindings()){
        WorkStation workStation = binding.getOwner();
        if(workStation!=null)
            workStations.add(workStation);
    }
    return workStations;
}