class VersionExclusionStrategy implements ExclusionStrategy {

    private String versionNumber;

    VersionExclusionStrategy(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    @Override
    public boolean shouldSkipClass(Class<?> classType) {
        VersionAnnotation va = classType.getAnnotation(VersionAnnotation.class);

        return va != null && versionCompare(this.versionNumber, va.versionNumber()) < 0;
    }

    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        VersionAnnotation va = fieldAttributes.getAnnotation(VersionAnnotation.class);

        return va != null && versionCompare(this.versionNumber, va.versionNumber()) < 0;
    }

    private static int versionCompare(String str1, String str2) {
        // TODO implement
    }
}