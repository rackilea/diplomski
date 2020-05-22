package com;

import javafx.application.Application;
import javafx.print.PrinterJob;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends Application {

    protected ConfigurableApplicationContext springContext;

    public static void main(final String[] args) {
        System.setProperty("java.awt.headless", "false");
        Application.launch(args);
    }

    @Override
    public void init() {
        springContext = springBootApplicationContext();
    }

    @Override
    public void start(final Stage stage) {
        // Create the PrinterJob
        PrinterJob job = PrinterJob.createPrinterJob();

        if (job == null)
        {
            return;
        }

        // Show the page setup dialog
        boolean proceed = job.showPageSetupDialog(stage);

        if (proceed)
        {
            System.out.println("SUCCESS");
        }
    }

    @Override
    public void stop() {
        springContext.close();
    }


    private ConfigurableApplicationContext springBootApplicationContext() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Main.class);
        String[] args = getParameters().getRaw().toArray(new String[0]);
        return builder.run(args);
    }
}