public void setscr(Stage stage)throws IOException{
        // there seems to be a try missing somewhere
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("first.fxml"));
        Parent parent = loader.load();
        Scene s=new Scene(parent);

        Platform.runLater(() -> {
            // scene update on javafx application thread
            stage.setScene(s);
            stage.show();
        });

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

}