private JScrollPane setInformacion() {
    T1.append("Information, bla bla bla");
    ...

    informacion.setViewportView(T1);

    ...
    informacion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    return informacion;
}