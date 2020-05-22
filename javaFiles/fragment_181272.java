public class Happy_numbers {
    public static void main(String[] args) throws IOException{

        String s = "./data.txt";

        FileInputStream fin = new FileInputStream(s);
        InputStreamReader in = new InputStreamReader(fin);
        BufferedReader br = new BufferedReader(in);
        int num;
        while((s = br.readLine()) != null) {
            num = Integer.parseInt(s);

            Ishappy ishappy = new Ishappy(num,Thread.currentThread()); 
            ishappy.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(1);
                continue;   // here is another problem, infinit loop
            }
            if(ishappy.isAlive()) {
                ishappy.Exit();
                System.out.println(0);
            } else
                System.out.println(11);

        }
        br.close();
        in.close();
        fin.close();
        System.out.println("DONE");
    }
}