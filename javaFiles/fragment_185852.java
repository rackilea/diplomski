private ArrayList<coffee> baseCoffeeList;
//...initialize baseCoffeeList like you did before in onActivityCreated

public void resetList() {
    setListAdapter(new coffee_adapter(getActivity(), baseCoffeeList));
}