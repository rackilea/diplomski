public static HashMap<String,String> countries = new HashMap<>();

public static void createCountryCode(String countryName, String countrycode) {
    if (countries.size() >= 20) {
        System.out.println("Full");
    } else {
        System.out.println("Saving the number of " + countryName + ":" + countrycode);
        countries.put(countryName,countrycode);
    }
}

public static void searchCoutryCode(String countryName) {
    String countryCode = countries.get(countryName);
    if(countryCode == null){
        System.out.println("No records");
    }

    else{
        System.out.println("countryName+ " : "+ countryCode");
    }
}