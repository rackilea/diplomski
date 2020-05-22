public int indexOf(Object data) {
    if (data instanceof AssassinNodeData) {
        return super.indexOf(data);
    } else if (data instanceof String) {
        return super.indexOf(new AssassinNodeData((String)data));
    } else {
        return -1;
    }
}