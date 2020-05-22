final class Example {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter blood type: ");
        String btx = sc.nextLine();

        System.out.print("Enter rhFactor: ");
        String rhx = sc.nextLine();

        BloodData data = btx.isEmpty() || rhx.isEmpty() ? 
                new BloodData() : 
                new BloodData(btx, rhx);

        System.out.println(data.getBloodType());
        System.out.println(data.getRhFactor());
    }
}

final class BloodData {

    private final String bloodType;
    private final String rhFactor;

    BloodData() {
        this("O", "+");
    }

    public BloodData(String bloodType, String rhFactor) {
        this.bloodType = bloodType;
        this.rhFactor = rhFactor;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getRhFactor() {
        return rhFactor;
    }
}