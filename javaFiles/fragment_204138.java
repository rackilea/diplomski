title = spinnerTitle.getSelectedItem().toString();
firstName = editTextFirstName.getText().toString();
lastName = editTextLastName.getText().toString();
address1 = editTextAddress1.getText().toString();
adddress2 = editTextAddress2.getText().toString();
city = editTextCity.getText().toString();
county = editTextCounty.getText().toString();
postCode = editTextPostCode.getText().toString();
country = spinnerCountry.getSelectedItem().toString();
dayPhone = editTextDayPhone.getText().toString();
evePhone = editTextEvePhone.getText().toString();

String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
            + "<users><Title>"+title+"</Title>"
            + "<FirstName>"+firstName+"</FirstName>"
            + "<LastName>"+lastName+"</LastName>"
            + "<Address1>"+address1+"</Address1>"
            + "<Address2>"+adddress2+"</Address2>"
            + "<LoginID>"+userId+"</LoginID>"
            + "<Password>"+password+"</Password>"
            + "<County>"+county+"</County>"
            + "<City>"+city+"</City>"
            + "<Country>"+country+"</Country>"
            + "<PostCode>"+postCode+"</PostCode>"
            + "<Email>"+email+"</Email>"
            + "<DayPhone>"+dayPhone+"</DayPhone>"
            + "<EvePhone>"+evePhone+"</EvePhone>" + "</users>";

            serverCall(xml);


private void serverCall(final String xml )
{

 ConnectivityManager conMan = ( ConnectivityManager ) getSystemService( Context.CONNECTIVITY_SERVICE );
 if( conMan.getActiveNetworkInfo() != null && conMan.getActiveNetworkInfo().isConnected() )
  {

     result = new Connection().getResponse("http://localhost/registration.php" , xml);
     if(result.equals("yes") {
       //registration done
     } else {
       //failed
     }
   }
}