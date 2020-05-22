Bill (String total, int people, int tip) {
    Total = total;
    Tip = tip;
    People = people;
    Split = (Double.parseDouble(Total) * ((double)Tip / 100)) / (double)People;
}