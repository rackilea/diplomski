FileInputStream fileIn = openFileInput("mytextfile.txt");
InputStreamReader inputRead = new InputStreamReader(fileIn);
BufferedReader reader = new BufferedReader(inputRead);

while ((str = reader.readLine()) != null){
    if(str.contains("##") && str.contains("userot"){
        while ((str = reader.readLine()) != null){
            if(str.contains("##"))
              break;
            else
              Log.d("TAG","output: " + str);
        }
        break;
     }
}