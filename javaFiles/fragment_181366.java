public class UrlMonitor implements Runnable {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.example.com/");
        Runnable monitor = new UrlMonitor(url);
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleWithFixedDelay(monitor, 0, 30, TimeUnit.SECONDS);
    }

    private final URL url;

    public UrlMonitor(URL url) {
        this.url = url;
    }

    public void run() {
        try {
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                sendAlertEmail();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendAlertEmail() {
        try {
            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.host", "smtp.example.com");

            Session session = Session.getDefaultInstance(props, null);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("me@example.com", "Monitor"));
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress("me@example.com"));
            message.setSubject("Alert!");
            message.setText("Alert!");

            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}