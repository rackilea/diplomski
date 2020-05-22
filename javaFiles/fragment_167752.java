try 
{
 sendPhoto(sendPhoto); // Call method to send the photo with caption
} 
catch (TelegramApiException e) 
{
   e.printStackTrace();
}