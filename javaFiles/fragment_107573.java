private void process () {

    for (String li : a)
    {
        String[] data = li.split("\\t");

        Index = Double.parseDouble(data[0]);
        Customers = Double.parseDouble(data[1]);; //per year
        rateOfBuy = Double.parseDouble(data[2]); //per year
        rateOfBusiness.add(Customers*rateOfBuy);  //Do math and store for that customer
    }
}