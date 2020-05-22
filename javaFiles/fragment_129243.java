public void stateChanged(ChangeEvent e) {

    System.out.println("!! Ping !!" + e.getSource());

    if (e.getSource() == ventana.sliderLargoPuntas) {
        dibujo.setLargoDePuntas(ventana.sliderLargoPuntas.getScaledValue());
    } else if (e.getSource() == ventana.sliderTamanioEstrella) {
        dibujo.setTamanio(ventana.sliderTamanioEstrella.getValue());

    } else if (e.getSource() == ventana.spinnerCantidadPuntas) {
        dibujo.setCantidadPuntas((int) ventana.spinnerCantidadPuntas.getValue());

    // >>--- Change this ------------------------------------------------------------<<
    //} else if (e.getSource() == ventana.ccColor) {
    } else if (e.getSource() == ventana.ccColor.getSelectionModel()) {

        System.out.println("!! Pong !!");
        dibujo.setColor(ventana.ccColor.getColor());
    }
    areaDeTrabajo.pintarEstrella(dibujo);
}