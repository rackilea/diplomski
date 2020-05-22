public ArrayList detectPingPongArray(
        int threshold_access_session_time,
        int threshold_transition_time,
        ArrayList<Dados> dadosSTA
) {
    dadosArray=dadosSTA;
    for(int i = 1; i<arrayDeDados.size()-1; i++) {
        dadosArray.get(i).setPingPong();
    }
    return dadosArray;
}