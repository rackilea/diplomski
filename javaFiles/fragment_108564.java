// List all the currency codes.
for (CurrencyCode code : CurrencyCode.values())
{
    System.out.format("[%s] %03d %s\n", code, code.getNumeric(), code.getName());
}

// List all the country codes.
for (CountryCode code : CountryCode.values())
{
    System.out.format("[%s] %s\n", code, code.getName());
}