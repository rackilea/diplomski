@Override
public void onStop()
{
    super.onStop();
    try{

       FileOutputStream fOut = openFileOutput("savedVinyls", Context.MODE_PRIVATE);
       String vinylString = "Test";

       fOut.write(vinylString.getBytes());
       fOut.close();

    }
    catch(IOException OE){
        OE.getStackTrace();

    }
}