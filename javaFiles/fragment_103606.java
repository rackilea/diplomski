public class Test {
    public static void main(String[] args) {    
        getBuildInformation(Arrays.asList("TEST", "test"));
    }
    private static void getBuildInformation(List<String> lines) {
        Supplier<Stream<String>> streamSupplier = () -> lines.stream();

        Optional<String> hasBuildNumber = streamSupplier.get().filter(s -> s.contains("t")).findFirst();
        System.out.println(hasBuildNumber);

        Optional<String> hasSCMRevision = streamSupplier.get().filter(s -> s.contains("T")).findFirst();
        System.out.println(hasSCMRevision);

    }
}