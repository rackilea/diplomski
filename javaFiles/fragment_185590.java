@Override
public void onItemSelected(AdapterView<?> parent, View view,
                int position, long id) {
      currImage = images[position];  
      Toast.makeText(getBaseContext(), "Anda memilih genre film "+ genre[index], Toast.LENGTH_SHORT)
                .show();
      setCurrentImage(); // called method
}