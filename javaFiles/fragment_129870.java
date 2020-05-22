public class PhoneFactory {

    public static Phone newPhone (String brand, int weight) {
        return new Phone(brand, weight);
    }

    public static Phone newPhone (String brand, int weight, String tech) {
        return new SmartPhone(brand, weight, tech);
    }
}

Phone nokia = PhoneFactory.newPhone("Nokia", 295); // <- Regular Phone Instance
Phone iphone = PhoneFactory.newPhone("iPhone", 368, "4G"); // <- SmartPhone instance