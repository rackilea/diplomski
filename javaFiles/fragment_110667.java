public static void readFiles() throws Exception {
    int i = 1;
    BufferedReader reader = null;
    Scanner input = null;
    boolean fileFound = true;
    while(i <= 5){
        System.out.print("Enter a file name::::");
        input = new Scanner(System.in);
        if(input.hasNextLine()){
            try {
                File f = new File(input.nextLine());
                reader = new BufferedReader(new FileReader(f));
                String str = null;
                while((str = reader.readLine()) != null){
                    System.out.println(str);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found");
                fileFound = false;
                i++;
                continue;
            } catch (IOException e) {
                System.out.println("IOException");
                i++;
                continue;
            } catch (Exception e) {
                System.out.println("Some Other Exception");
                i++;
                continue;
            } finally{
                if(fileFound)
                    reader.close();
            }
        }

        i++;
    }

}