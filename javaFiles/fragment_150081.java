public class RunJava {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-jar", "dist/RunJava.jar");
        pb.redirectErrorStream();
        try {
            Process p = pb.start();
            InputStreamReader isr = new InputStreamReader(p.getInputStream());
            p.waitFor();
            isr.join();

            System.out.println("Process said [" + isr.getText() + "]");
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public static class InputStreamReader extends Thread {

        private InputStream is;
        private String text;

        public InputStreamReader(InputStream is) {
            this.is = is;
            start();
        }

        public String getText() {
            return text;
        }

        @Override
        public void run() {
            StringBuilder sb = new StringBuilder(64);
            int value = -1;
            try {
                while ((value = is.read()) != -1) {
                    sb.append((char)value);
                }
            } catch (IOException exp) {
                exp.printStackTrace();
                sb.append(exp.getMessage());
            }
            text = sb.toString();
        }

    }

}