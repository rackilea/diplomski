private SystemCodeTracking reduceList(List<SystemCodeTracking> list) throws Exception {
    if (list.isEmpty()) {
        throw new Exception();
    } else {
        SystemCodeTracking building = list.get(0);
        building.setId(0L);
        list.forEach(next -> building.setId(building.getId() + next.getId()));
        return building;
    }
}