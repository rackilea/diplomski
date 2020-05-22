String sommaRisultato = null;
if (somma<=5){
    sommaRisultato= "numero piccolo";
}else if (somma>5 && somma<7){
    sommaRisultato= "numero medio";
}else if (somma>=8){
    sommaRisultato= "numero alto";
}
txtRis.setText(String.valueOf("il risultato: " + sommaRisultato));