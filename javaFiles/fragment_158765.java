String FindCountry = "9Z";

Map<String, String> Cont = new HashMap<>();

Cont.put("BA-BE", "Angola");
Cont.put("9X-92", "Trinidad & Tobago");

for (String key : Cont.keySet()) {
    if (LOOKUP.indexOf(key.charAt(0)) == LOOKUP.indexOf(FindCountry.charAt(0)) &&
        LOOKUP.indexOf(FindCountry.charAt(1)) >= LOOKUP.indexOf(key.charAt(1)) &&
        LOOKUP.indexOf(FindCountry.charAt(1)) <= LOOKUP.indexOf(key.charAt(4))) {
        System.out.println("Country: " + Cont.get(key));
    }
}