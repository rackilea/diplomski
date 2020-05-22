public void testread(){

    System.out.println("Enter filename:\n");
    String filename=Keyboard.readInput();
    File myfile=new File(filename);
    try(BufferedReader scanfile=new BufferedReader(new FileReader(myfile))){
        String str;
        List<String>
        list=new ArrayList<String>();
        while((str=scanfile.readLine())!=null)
        {
            int i;
            list.add(str);
        }
        // then print the list
        for(i=0;i<list.size();i++) {
            System.out.println(list.get(i));
        }
    }catch (IOException e){
        // Print error in case of failure.
        System.out.println("Error reading from file " + e.getMessage());
    }
}