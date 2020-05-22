@FXML
private void addOfficeBarrierSelect() {
    App.getInstance().showProgressIndicator(myController);
    Task<ScreensController> task = new Task<Void>() {
        @Override
        protected ScreensController call() throws Exception {
            ScreensController colllectScreenController = new ScreensController();
            colllectScreenController.loadScreen(Screens.ADD_OFFICE_BARRIER);
            colllectScreenController.setScreen(Screens.ADD_OFFICE_BARRIER);
            return colllectScreenController;
        }

        @Override
        protected void succeeded() {
            super.succeeded();
            content.setContent(getValue());
            App.getInstance().hideProgressIndicator(myController);
        }

        @Override
        protected void failed() {
            super.failed();
            App.getInstance().hideProgressIndicator(myController);
        }
    };
    new Thread(task).start();
}