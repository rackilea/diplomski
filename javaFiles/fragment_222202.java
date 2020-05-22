private EventHandler<WindowEvent> confirmCloseEventHandler = event -> {
        // close event handling logic.
        // consume the event if you wish to cancel the close operation.
}

...

stage.setOnCloseRequest(confirmCloseEventHandler);

Button closeButton = new Button("Close Application");
closeButton.setOnAction(event ->
        stage.fireEvent(
                new WindowEvent(
                        stage,
                        WindowEvent.WINDOW_CLOSE_REQUEST
                )
        )
);