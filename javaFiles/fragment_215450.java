public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        Currency currency = new Currency();

        String jsonStr = getJson();


        try {
            currency = mapper.readValue(jsonStr, Currency.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(jsonStr);

        System.out.println(currency.getSingleRate("BGN"));

        System.out.println("finished");
    }