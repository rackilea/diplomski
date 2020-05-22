} catch (Exception e) {
    System.out.println("Exception caught in task!");
    Platform.runLater(() -> {
        Alert dialog = new Alert(AlertType.ERROR, "Error", ButtonType.OK);
        dialog.show();
    });
}