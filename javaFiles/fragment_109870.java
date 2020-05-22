@Override
public void onServerResponded(String responce)
{
    Toast.makeText(MainActivity.this, "Server responded",      Toast.LENGTH_SHORT).show();
    JsonParser parser=new JsonParser(getApplicationContext(),responce);
    parser.setOnJsonParseListner(new JsonParser.OnCustomersParserListner() {
        @Override
        public void onCustomersParsed(List<Customer> customers) {
            Toast.makeText(MainActivity.this, customers.get(0).getFirstname(), Toast.LENGTH_SHORT).show();
        }
    });
    parser.parseCustomers();

}