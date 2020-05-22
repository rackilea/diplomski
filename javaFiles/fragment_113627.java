public class Example {

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        new Timer().scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {

                System.out.println(LocalTime.now().format(formatter));
            }
        }, 0, 1000);
    }
}