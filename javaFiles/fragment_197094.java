List<Long> managersId = new ArrayList<Long>();

collabs = CollabLocalServiceUtil.getCollabs(-1, -1);

long id;
for (int i = 0; i < collabs.size(); i++) {
    id = collabs.get(i).getManagerId();
    synchronized (managersId) {
        if (!managersId.contains(id)) {
            managersId.add((Long) id);
        }
    }
}