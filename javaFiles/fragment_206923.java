private String message = "HELLO\n";
...
while(true) {
            try {
                Thread.sleep(2000);
                writer.write(message);
                writer.flush();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }