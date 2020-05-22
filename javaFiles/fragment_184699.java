public class Version implements Comparable<Version> {

    private final int major;
    private final int minor;
    private final int bug;
    private final int release;
    private final int build;

    public Version(int major, int minor, int bug, int release, int build) {
        this.major = major;
        this.minor = minor;
        this.bug = bug;
        this.release = release;
        this.build = build;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getBug() {
        return bug;
    }

    public int getRelease() {
        return release;
    }

    public int getBuild() {
        return build;
    }

    @Override
    public String toString() {
        return "Version{" +
                "major=" + major +
                ", minor=" + minor +
                ", bug=" + bug +
                ", release=" + release +
                ", build=" + build +
                '}';
    }



    public static Version create(String value){

        String[] splitRes = value.split("_");
        List<Integer> intValues = new ArrayList<>();

        for(String v : splitRes){
            intValues.add(Integer.parseInt(v));
        }

        return create(intValues);
    }

    public static Version create(List<Integer> values){

        if(Objects.requireNonNull(values).size() < 5)
            throw new IllegalArgumentException();

        return new Version(
                values.get(0),
                values.get(1),
                values.get(2),
                values.get(3),
                values.get(4)
        );
    }


    @Override
    public int compareTo(Version that) {
        if (this.major > that.major) {
            return -1;
        } else if (this.major < that.major) {
            return 1;
        }

        if (this.minor > that.minor) {
            return -1;
        } else if (this.minor < that.minor) {
            return 1;
        }

        if (this.bug > that.bug) {
            return -1;
        } else if (this.bug < that.bug) {
            return 1;
        }

        if (this.release > that.release) {
            return -1;
        } else if (this.release < that.release) {
            return 1;
        }

        if (this.build > that.build) {
            return -1;
        } else if (this.build < that.build) {
            return 1;
        }
        return 0;
    }
}