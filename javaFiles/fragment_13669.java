static class Schema {
    final String schemaName;
    final boolean isDefault;

    Schema(String schemaName, boolean isDefault) {
        this.schemaName = schemaName;
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "Schema{" +
                "schemaName='" + schemaName + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }
}