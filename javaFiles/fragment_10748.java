strNombreApellido = JOptionPane.showInputDialog("Ingrese el nombre y apellido");
    while (!strNombreApellido.toUpperCase().equals("FIN")) {
    //stuff

    //take name again at the end of the loop iteration
    strNombreApellido = JOptionPane.showInputDialog("Ingrese el nombre y apellido");
}