int menuItem = -1;
while(menuItem != 0){
    menuItem = menu();
    switch (menuItem){
        case 1:
            showTaskList();
            break;
        case 2:
            addTask();
            break;
        case 3:
            sortList();
            break; //The missing break
        case 4:
            deleteTasks();
            break;
        case 0:
            break;
        default:
            System.out.println("Invalid Input");
    }
}