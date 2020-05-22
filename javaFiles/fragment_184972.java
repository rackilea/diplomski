package se.skplay.scaenicos.subWindows.casparConnection;

import java.io.IOException;

import javafx.concurrent.Task ;

import se.skplay.scaenicos.Connections;

public class Connect extends Task<Void> {

    private String host;
    private int port;

    public Connect(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Void call() {
        try {
            connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void connect() throws IOException {
        Connections.setCaspar(host, port);
        // You can never close a stage from a background thread
        // CasparConnectonController.getStage().close();
    }

}