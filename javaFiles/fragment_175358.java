StringBuilder results = new StringBuilder();
int size = int size = sharedPreferences.getInt("size", 0); // get the size to start looping
if(size == 0){ // if results are empty
    // show toast there is no saved result
} else { //start looping
    for(int i = 0; i < size; i++){
        String temp = sharedPreferences.getString("result" + String.valueOf(i), DEFAULT);
        results.append(temp + " ");
    }
    resultPhysical.setText(results.toString());
}