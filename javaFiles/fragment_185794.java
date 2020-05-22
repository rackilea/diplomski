boolean countryDropdown = false;

String[] countryOptions = selenium.getSelectOptions("id=address.country");
for (String option : countryOptions) {
    if (option.equals(aString)) {
        countryDropdown = true;
        break;
    }
}