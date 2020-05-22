public class DesktopContent implements ContentManager {
    private final Pane desktop;
    private final AtomicReference<Node> weather = new AtomicReference<>();

    @Override
    public void setWeatherWidget(Node node) {
        updateFX(() -> replaceNode(desktop.getChildren(), weather, node));
    }

    private void updateFX(Runnable runnable) {
        try {
            if (Platform.isFxApplicationThread()) {
                runnable.run();
            } else {
                FutureTask<Void> task = new FutureTask<>(runnable, null);
                Platform.runLater(task);
                // block until task completes:
                task.get();
            } 
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "While waiting for 'updating' condition", e);
        }
    }

    private void replaceNode(List<Node> children, AtomicReference<Node> current, Node newNode) {
        SequentialTransition st = new SequentialTransition();
        ObservableList<Animation> transformations = st.getChildren();
        Node oldNode = current.getAndSet(newNode);

        if (oldNode != null) {
            FadeTransition ft = new FadeTransition(Duration.millis(350), oldNode);
            ft.setToValue(0d);
            ft.setOnFinished(e -> children.remove(oldNode));
            transformations.add(ft);
        }

        if (newNode != null) {
            newNode.setLayoutX(100d);
            newNode.setLayoutY(100d);
            FadeTransition ft = new FadeTransition(Duration.millis(350), newNode);
            ft.setFromValue(0d);
            ft.setToValue(1d);
            children.add(newNode);
            transformations.add(ft);
        }

        st.play();

    }

}