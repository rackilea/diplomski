protected String paramString() {
    final String thisName = Objects.toString(getName(), "");
    final String invalid = isValid() ? "" : ",invalid";
    final String hidden = visible ? "" : ",hidden";
    final String disabled = enabled ? "" : ",disabled";
    return thisName + ',' + x + ',' + y + ',' + width + 'x' + height
            + invalid + hidden + disabled;
}