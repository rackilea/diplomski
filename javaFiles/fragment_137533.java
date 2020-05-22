private void searchByYear(BTNode root, int year) {
    BTNode temp = root;
    if(temp == null)
        return;
    if(temp.data.titleYear == year){
        System.out.println(temp.data.title);
    }

    searchByYear(temp.left, year);
    searchByYear(temp.right, year);
 }