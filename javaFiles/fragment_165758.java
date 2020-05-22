// -SNIP-
if(validate(number))
{
    dm.finalupdate(mailid,productnamearray,checkarray,id_array);
                Toast.makeText(getApplicationContext(),"Transaction completed!",Toast.LENGTH_LONG).show();
    btnccconfirm.setVisibility(View.INVISIBLE);

    onBackPressed();
}
else
{
    Toast.makeText(getApplicationContext(),"Invalid credit card number",Toast.LENGTH_LONG).show();
}