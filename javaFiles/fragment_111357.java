public static void main(String[] args) throws Exception {

        Currency usd = java.util.Currency.getInstance("USD");
        NumberFormat format = java.text.NumberFormat.getCurrencyInstance(java.util.Locale.US);
        format.setCurrency(usd);
        System.out.println(format.format(23232312));
    }