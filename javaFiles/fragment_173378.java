class Version implements Comparable<Version> {

    private String versionStr;
    private int[] arr;

    public String getVersionStr() { return versionStr; }

    @Override public String toString() { return versionStr; }

    @Override
    public int compareTo(Version other) {

        int result = Integer.compare(arr[0], other.arr[0]);

        if (result != other)
            return result;

        return Integer.compare(arr[1], other.arr[1]);
    }

    public Version(String versionStr) {
        this.versionStr = versionStr;
        this.arr = Stream.of(versionStr.split("\\."))
                .limit(2)//get only two first elements
                .mapToInt(Integer::parseInt)//convert String to int
                .toArray();//create array with integers
    }

}

class Demo {

    public static void main(String[] args) {

        List<Version> list = new ArrayList<Version>();

        list.add(new Version("3.3.x"));
        list.add(new Version("1.2.x"));
        list.add(new Version("1.11.x"));
        list.add(new Version("2.3.x"));

        Collections.sort(list);//with use default order provided by compareTo(Version other)

        for (Version str : list)
            System.out.println(str);
    }
}