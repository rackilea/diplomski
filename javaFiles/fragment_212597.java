public class test {

    public static void main(String[] args) {
// start thread to write to file
        new Thread(new Runnable() {
            @Override
            public void run() {
                FileWriter writer;
                try {
                    int i = 1;
                    writer = new FileWriter("D:\\text.txt");
                    writer.append("line"+ i++ + "\n");
                    writer.flush();
                    while (true)
                    {
                        writer.append("line"+ i++ + "\n");
                        writer.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        // start thread to read file
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FileReader reader = new FileReader("D:\\text.txt");
                    BufferedReader br = new BufferedReader(reader);
                    String detail;
                    while ((detail =br.readLine()) != null)
                    {
                        System.out.println(detail);
                    }
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}