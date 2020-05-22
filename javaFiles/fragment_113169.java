public static ArrayList<String> get_arraylist_from_file(File f) throws FileNotFoundException {
        Scanner scanner;
        ArrayList<String> list = new ArrayList<String>();
        scanner = new Scanner(f);
        String s = scanner.nextLine();

        while(scanner.hasNextLine()){
        String[] tempList = s.split("&"); //This will give you this [title][ DVD]
        String title = tempList[0];
        String type = tempList[1].subString(1); //If you want the input at the place of DVD, with the space removed
        list.add(title);
        s = scanner.nextLine();
        }
        scanner.close();
        return list;
}