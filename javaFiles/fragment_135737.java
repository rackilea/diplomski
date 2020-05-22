class InRead {

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("FSA.txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while ((str = br.readLine()) != null) {
                if (str.equals("A") || str.equals("B") || str.equals("c")) //compare
                    out.println(str);
                else
                    throw new Exception(); //throw exception
            }

            br.close();
        } catch (IOException e) {
            out.println("File not found");
        }

        catch (Exception e) {//catch it here and print the req message
            System.out.println("New Character Found");
        }
    }
}