Date lasttimeran = null;
Date now = null;
long diff = now.getTime() - lasttimeran.getTime();
long diffMinutes = diff / (60 * 1000);
//If block to check if it has been long enough >= ensures a diff of exactly 24 hours will still trigger the method to be ran
if (diffMinutes >= 1440) {
//Do Something
}
else{
//Do Nothing
}