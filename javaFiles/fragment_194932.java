int servicios = 0;

if (servicio1s == true){
    servicios += Integer.parseInt(JOptionPane.showInputDialog("Favor digite el monto a pagar por el servicio: Electricidad"));
}

if (servicio2s == true){
    servicios += Integer.parseInt(JOptionPane.showInputDialog("Favor digite el monto a pagar por el servicio: Agua"));
}

if (servicio3s == true){
    servicios += Integer.parseInt(JOptionPane.showInputDialog("Favor digite el monto a pagar por el servicio: Telefono"));
}

if (servicio4s == true){
    servicios += Integer.parseInt(JOptionPane.showInputDialog("Favor digite el monto a pagar por el servicio: Otro"));
}

return servicios;