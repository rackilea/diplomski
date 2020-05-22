public List<IMode> getConversions(List<IType> types) {
    List<IMode> modes = new ArrayList<IMode>(types.size());
    for (IType type : types) {
        IMode iMode = convert(type);
        modes.add(iMode);
    }
    return modes;
}