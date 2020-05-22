public class ClassNameRecordingRemapper extends Remapper {

    private final Set<? super String> classNames;

    public ClassNameRecordingRemapper(Set<? super String> classNames) {
        this.classNames = classNames;
    }

    @Override
    public String mapType(String type) {
        classNames.add(type);
        return type;
    }

}