public class TestInput {


    public String myReader(){
        boolean isExit = true;
        while (isExit){
            System.out.print("$");
            BufferedReader br = new BufferedReader( new InputStreamReader( System.in));

            try {
                String readLine = br.readLine();
                if (readLine != null && readLine.trim().length() > 0){
                    if (readLine.equalsIgnoreCase("showlist")){
                        System.out.println("List 1");
                        System.out.println("List 2");
                        System.out.println("List 3");
                    } if (readLine.equalsIgnoreCase("shownewlist")){
                        System.out.println("New List 1");
                        System.out.println("New List 2");
                    } if (readLine.equalsIgnoreCase("exit")){
                        isExit = false;
                    }
                } else {
                    System.out.println("Please enter proper instrictions");
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        return "Finished";
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Please Enter inputs for the questions asked");
        TestInput ti = new TestInput();
        String reader = ti.myReader();
        System.out.println(reader);
    }