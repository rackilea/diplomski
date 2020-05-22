String line = "30000000000000010300000000000000000000009876543210";
if (line.length() >= 22) {
    BigDecimal amount = new BigDecimal(
            line.substring(2, 24).replaceFirst("^(.*)(..)$", "$1.$2")
    );
    System.out.println(amount);
}