String[] menuArray;
if(menuList.size != 0){
   writeToFile("Menu List", menuList);
   menuArray = menuList.toArray(new String[menuList.size()]);
} else {
   menuArray = readFromFile("Menu List");
}