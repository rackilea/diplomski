ArrayList<Model> list = new ArrayList<>(); 
for(int i = 0; i < myList.size(); i++)
{
    model.setName("Anything");
    model.setPosition("Jr");
    model.setDepartment("It");
    model.setDate(myList.get(i));

    list.addAll(DAO.get(model)); //Get elements, and add them to the list
}