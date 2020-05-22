String query = "INSERT INTO Paciente(IDPaciente, NomePaciente, IdadePaciente, LocalidadePaciente) VALUES('"+IDTextField.getText()+"', '"+NomeTextField.getText()+"', '"+IdadeTextField.getText()+"', '"+LocalidadeTextField.getText()+"')";
try
{
    st = con.DatabaseConnection().createStatement();
    rs = st.executeQuery(query);
}