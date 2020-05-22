public class Mailer {
    public void sendMailWithAttachment(
        String attachment
    ) {
        //code here
    }
}

public class AppTest3 {
    private Mailer mailer;
    public AppTest3 (
        Mailer mailer
    ) {
       this.mailer = mailer;
    }
    public void run() {
        // do some crazy things here and
        this.mailer.sendMailWithAttachment(
            "crazy file content"
        );
    }
}

public class AppTest3Factory {
    public AppTest3 createAppTest3() {
       return new AppTest3(
          new Mailer();
       );
    }
}

public class Main {
    public static void main(
        String [] args
    ) {
        AppTest3Factory appFactory = new AppTest3Factory();
        AppTest3 app = appFactory.createAppTest3();
        app.run();
    }
}