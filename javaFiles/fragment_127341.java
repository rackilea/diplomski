if (naam == null || naam.equals("")) {
//  ^---------------^------------------ no `this.` here
    throw new IllegalArgumentException("Fill in name");
} else {
    this.naam = naam;
}