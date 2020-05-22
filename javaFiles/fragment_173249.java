public static void main(String[] args) {
    Runtime.getRuntime().addShutdownHook(
        new Thread(
            new Runnable() {
                @Override
                public void run() {
                    System.out.println("Shutdown");
                }
            }));            
}