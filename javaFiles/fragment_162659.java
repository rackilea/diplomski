Process process = Runtime.getRuntime().exec(chmod); 
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

String line;
while ((line = bufferedReader.readLine()) != null){

    Log.d("myTAG", line);
}