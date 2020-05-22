package de.scrum_master.app;

public class Application {
    public static String locale = "EN";

    public static void main(String[] args) throws Exception {
        Person albert = new Person("Albert", "Einstein");
        System.out.println("Showing localised captions for " + albert + ":");
        locale = "EN";
        System.out.println(albert.getAllCaptions());
        System.out.println(albert.getCaptionValuePairs());
        locale = "FR";
        System.out.println(albert.getAllCaptions());
        System.out.println(albert.getCaptionValuePairs());
        locale = "RU";
        System.out.println(albert.getAllCaptions());
        System.out.println(albert.getCaptionValuePairs());
    }
}