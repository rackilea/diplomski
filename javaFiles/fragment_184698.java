public class Main {

    public static void main(String[] args){

        List<Version> versions = Arrays.asList(
                Version.create("1_10_2_0_154"),
                Version.create("3_10_5_2_10"),
                Version.create("2_10_4_1_49"),
                Version.create("3_10_5_1_37"));

        versions.sort(Version::compareTo);

        System.out.println(versions.get(0).toString());
    }

}