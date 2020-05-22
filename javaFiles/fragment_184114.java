String dpaResult;
//Sorts the DPA Matrix
if (dpa<=10){
    dpaResult = "Baixo";
}else if (dpa>10 && dpa<16){
    dpaResult = "Médio";
}else {
    dpaResult = "Alto";
}

textResultado.setText(String.valueOf("O resultado é: " + dpa + "; Result: " + dpaResult));