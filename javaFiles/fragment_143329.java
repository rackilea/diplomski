public void mostrar() {
    TextView nome = (TextView) findViewById(R.id.texto_1);
    TextView descricao = (TextView) findViewById(R.id.texto_2);
    TextView data_criacao = (TextView) findViewById(R.id.texto_3);
    c = db.query(false, Contrato.Notas.TABLE_NAME, Contrato.Notas.PROJECTION, Contrato.Notas.COLUMN_ID_USER + "= ? ", new String[]{nota}, null, null, null, null);
    // edited here ,try to change nome to nomeString
    if (null == c) {
        return;
    }
    if(c.moveToFirst()){
        String nomeString = c.getString(c.getColumnIndex(Contrato.Notas.COLUMN_NOME));
        String descricaoString = c.getString(c.getColumnIndex(Contrato.Notas.COLUMN_NOME));
        String data_criacaoString = c.getString(c.getColumnIndex(Contrato.Notas.COLUMN_NOME));
        // then set to your textview
        nome.setText(nomeString);
        descricao.setText(descricaoString);
        data_criacao.setText(data_criacaoString);
    }
}