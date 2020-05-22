private class CloningRelations {
    List<CloningOrder> orders;

    public Long getRoot(){
        for (CloningOrder o : orders)
            if (o.getParent() != null)
                return o.getId();
        return null;
    }

    @JsonIgnore public List<Long> getChildrenOf(long id) {
        ArrayList<Long> list = new ArrayList<>();
        for (CloningOrder o : orders)
            if (o.getParent() == id)
                list.add(o.getId());
        return list;
    }

    @JsonIgnore public List<Long> getDescendantsOf(long id) {
        ArrayList<Long> list = new ArrayList<>();
        for (CloningOrder o : orders)
            if (o.getParent() == id) {
                list.add(o.getId());
                list.addAll(getDescendantsOf(o.getId()));
            }
        return list;
    }

    @JsonIgnore public Long getParentOf(long id) {
        for (CloningOrder o : orders)
            if (o.getId() == id)
                return o.getParent();
        return null;
    }

    @JsonIgnore public List<Long> getAncestorsOf(long id) {
        ArrayList<Long> list = new ArrayList<>();
        for (CloningOrder o : orders)
            if (o.getId() == id) {
                list.add(o.getParent()); //sorted too!
                list.addAll(getAncestorsOf(o.getParent()));
            }
        return list;
    }

    private class CloningOrder {
        long id;
        Long parent;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public Long getParent() {
            return parent;
        }

        public void setParent(Long parent) {
            this.parent = parent;
        }

    }
}