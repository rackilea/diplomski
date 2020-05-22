try 
{
     JSONObject obj = new JSONObject(new String(responseBody));
     if (obj.getString("status").equalsIgnoreCase("success") {
                    Toast.makeText(getApplicationContext(), "Selamat datang!", Toast.LENGTH_LONG).show();
     navigatetoMainActivity();
}
else {
    errorMsg.setText(obj.getString("error_msg"));
    Toast.makeText(getApplicationContext(), obj.getString("error_msg"), Toast.LENGTH_LONG).show();
}
}