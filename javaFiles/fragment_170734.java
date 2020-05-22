public Cartao parseJSON(String jsonParam){

    Cartao jsonCartao = new Cartao();

    try {
        JSONObject json = (JSONObject) new JSONTokener(jsonParam).nextValue();
        jsonCartao = new Cartao(
            json.getString("NomeCartao"), 
            json.getDouble("SaldoRestante"), 
            json.getString("NomePessoa"),    
            json.getDouble("ValorUltimoCredito"), 
            json.getString("DataUltimoCredito"), 
            json.getBoolean("Status"));
    } catch (Exception e) {
        e.printStackTrace();
    }
    return jsonCartao;
}