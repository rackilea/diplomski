class ShopAssist {

    private Items items = new Items();
    ...

    public static void main(String[] args){

      ShopAssist shopAssist = new ShopAssist();

      while (true) {
        System.out.println("( Add | Remove | Show | Exit )");
        System.out.print(">");
        Scanner menuinput = new Scanner(System.in);
        String choice = menuinput.nextLine();

        if (choice.equals("Add")) {
          shopAssist.addItem();
        } 
        else if (choice.equals("Remove")) {
          shopAssist.removeItem();
        } 
        else if (choice.equals("Show")) {
          shopAssist.showItems();
        }
      }
    }

    public void addItem(){
        ...
    }
    ...
    public void showItems(){          
        System.out.println("ShowItems Method");
        System.out.println(items.checklist);
    }
    ...
}