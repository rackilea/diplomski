{
    name = Root;
    children = ("Home","Person","Computer", "ComputerModels");
},
{
    name = "Home";
    action = "session.navController.homeAction";
},
{
    name = Person;
    action = "session.navController.listPersonAction";
    children = ("createPerson", "findPerson", "Logout");
},
{
    name = createPerson;
    action = "session.navController.createPersonAction";
},
{
    name = findPerson;
    action = "session.navController.findPersonAction";
}