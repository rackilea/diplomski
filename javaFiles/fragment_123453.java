if (naam == null || naam.trim().isEmpty()) {
    errors.add("User must have a name");
} 

if (straatnaam == null || straatnaam.trim().isEmpty()) {
    errors.add("Straatnaam must have a name");
} 

if (!this.validUsername(naam)) {
   errors.add("Naam: must be 3 to 10 characters a-zA-Z");
}  

if (!this.validStraatnaam(straatnaam)) {
    errors.add("Straatnaam: must be 3 to 50 characters a-zA-Z");
}