public void verificar(View dialogView){
    SharedPreferences sharedPref = getSharedPreferences("PREFS",Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    EditText b = dialogView.findViewById(R.id.userName);
    String nombre = b.getText().toString(); //Obtengo el nombre que se inserto en el cuadro
    editor.putInt("lastScore",cont);
    editor.putString("lastNombre",nombre);
    editor.commit();
    Intent intent = new Intent(getApplicationContext(),Ranking.class);
    startActivity(intent);


}