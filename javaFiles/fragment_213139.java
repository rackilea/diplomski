@FXML 
private void AddProgramare(ActionEvent event) throws SQLException, IOException  {


    String Interogare1= "INSERT INTO programaritest(Nume,Prenume,Data,Ora,Departament,Doctor,Nr_telefon) VALUES(?,?,?,?,?,?,?)";

    String nume=Nume.getText();
    String prenume=Prenume.getText();

    LocalDate data=Data.getValue(); 

    String ora=Ora.getText();
    String departament=Departament.getText();
    String doctor=Doctor.getText();
    String nr_telefon=Nr_telefon.getText();


    try {
        ConectaredB ConectaredB=new ConectaredB();
        Connection conexiune=ConectaredB.logareDB();
        PreparedStatement MG = conexiune.prepareStatement(Interogare1);


        MG.setString(1, nume);
        MG.setString(2, prenume);
        MG.setDate(3, Date.valueOf(data)); 
        MG.setString(4, ora);
        MG.setString(5, departament);
        MG.setString(6, doctor);
        MG.setString(7, nr_telefon);


        MG.executeUpdate();

        // ...
   } catch (SQLException exceptie1) {
       exceptie1.printStackTrace(); /
   }


}