public class TestClass {
    public enum Company {
        Google(1),
        Microsoft(2),
        JPMorgan(3),
        WellsFargo(4);

        private int companyRatings;

        private Company(int companyRatings) {
            this.companyRatings = companyRatings;
        }

        @Override
        public String toString() {
            return "Company Name : " + name() + " - Company Position : " + companyRatings;
        }
    }

    public static void enumComparison(Company type) {
        switch (type) {
            case Google:
            case Microsoft:
                System.out.println("[Technology Company]: " + type);
                break;
            case JPMorgan:
            case WellsFargo:
                System.out.println("[Investment Company]: " + type);
                break;
            default:
                System.out.println("[General... Company]: " + type);
                break;
        }
    }

    public static void main(String[] args) {
        enumComparison(Company.Google);
    }
}