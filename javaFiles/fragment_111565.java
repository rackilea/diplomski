public void deserialize(List <MySample>listan, String path) {
   double sum=0;
   int count=0;
   double average=0;
    try {
        File file = new File(path);
        ObjectInputStream in = new ObjectInputStream(new   
        FileInputStream(file));
        listan = (ArrayList<MySample>) in.readObject();

        for (Object o:listan){

            sum += Double.parseDouble((String) o);
            count ++;
            average = sum/count;

}

         System.out.printf("The average on %s är %.2f ", item, average);

        in.close();
    } catch (IOException e) {
        System.out.println(e.getMessage());
    } catch (ClassNotFoundException ex) {
        System.out.println(ex.getMessage());
    }

}