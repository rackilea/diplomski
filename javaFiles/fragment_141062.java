if(strPassword.equals(textPassword)&&strDeviceID.equals(textDeviceID) && strEmailID.equals(textEmailID))
{

Toast.makeText(getApplicationContext(), "Logged In", Toast.LENGTH_SHORT).show();
}
else
 Toast.makeText(getApplicationContext(), "Cannot Continue", Toast.LENGTH_SHORT).show();