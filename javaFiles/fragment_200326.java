private Optional<SocketHolder> getLiveSocket(final List<SocketHolder> listOfEndPoints) {
    if (!CollectionUtils.isEmpty(listOfEndPoints)) {
        // The list of live sockets
        List<SocketHolder> liveOnly = new ArrayList<>(listOfEndPoints.size());
        for (SocketHolder obj : listOfEndPoints) {
            if (obj.isLive()) {
                liveOnly.add(obj);
            }
        }
        if (!liveOnly.isEmpty()) {
            // The list is not empty so we shuffle it an return the first element
            Collections.shuffle(liveOnly);
            return Optional.of(liveOnly.get(0));
        }
    }
    return Optional.absent();
}