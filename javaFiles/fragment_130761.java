public String getMapping(String index, String type) throws EsuException {
    ClusterState cs = getClient().admin().cluster().prepareState().setFilterIndices(index).execute().actionGet().getState();
    IndexMetaData imd = cs.getMetaData().index(index);

    if (imd == null) {
        throw new EsuIndexDoesNotExistException(index);
    }

    MappingMetaData mmd = imd.mapping(type);

    if (mmd == null) {
        throw new EsuTypeDoesNotExistException(index, type);
    }

    String mapping = "";
    try {
        mapping = mmd.source().string();
    } catch (IOException e) {
        mapping = "{ \"" + e.toString() + "\"}";
    }
    return mapping;
}