TableColumn<Cita, String> columnaCitasPaciente ;

// ...

columnaCitasPaciente.setCellValueFactory(cellData -> 
    new SimpleStringProperty(cellData.getValue().getPaciente().getNombrePaciente()));
columnaCitasDentista.setCellValueFactory(cellData -> 
    new SimpleStringProperty(cellData.getValue().getEmpleado().getNombreEmpleado());