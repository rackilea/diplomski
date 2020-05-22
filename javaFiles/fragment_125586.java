Label aab=(Label) event.getSource();
aux=aab.getText();
FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/cita.fxml"));
Parent root = loader.load();

CitaController citaController = loader.getController();
citaController.setAux(aux);

// ...