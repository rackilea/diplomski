cb_company = new ComboBox("Company");

for(cCustomer cust : ListCust)
{
    cb_company.addItem(cust.mgetId);
    cb_company.setItemcaption(cust.mgetId, cuts.mgetName);
}

//select the first item from the container
cb_company.select(ListCust.get(0));