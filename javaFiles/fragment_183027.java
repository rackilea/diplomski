jugar.setOnAction(e -> {
    if(method == 1)
    {
        isInt(tiempo,tiempo.getText());
    }
    else if(method == 2)
    {
        getArbitro(jugadasArbitro);
    }
    else if(method == 3)
    {
        getOfensiva(jugadasOfensivas);
    }
    else if(method == 4)
    {
        getDefensa(jugadasDefensivas);
    }
});