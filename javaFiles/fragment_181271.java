public class Happy_numbers {

    static class Ishappy extends Thread {
        private Integer num;
        private Thread main;
        private volatile boolean out = false;

        private boolean unhappy = false;

        Ishappy(int i, Thread main) {
            this.main = main;
            num = i;
        }

        public boolean isUnhappy() {
            return unhappy;
        }

        void Exit() {
            out = true;
        }

        @Override
        public void run() {
            Set<Integer> sofar = new HashSet<Integer>();
            while(!out && num != 1) {
                unhappy = sofar.contains(num);
                if(num == 1 || unhappy) {
                    main.interrupt();
                    break;
                }

                sofar.add(num);

                String s = num.toString();
                int temp = 0;
                for(int i = 0 ; i < s.length(); i++) {
                    int x = Integer.parseInt(s.substring(i, i+1));
                    temp += x*x;
                }
                num = temp;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        byte path[] = null;

        String s = "./data.txt";

        FileInputStream fin = new FileInputStream(s);
        InputStreamReader in = new InputStreamReader(fin);
        BufferedReader br = new BufferedReader(in);
        int num;
        while((s = br.readLine()) != null) {
            num = Integer.parseInt(s);

            Ishappy ishappy = new Ishappy(num,Thread.currentThread()); 
            ishappy.start();
            ishappy.join();
            if(ishappy.isUnhappy()){
                System.out.println("Number ["+num+"] is not happy");
            }else{
                System.out.println("Number ["+num+"] is happy");
            }
        }
        br.close();
        in.close();
        fin.close();
    }
}