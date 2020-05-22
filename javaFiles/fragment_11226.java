{
    android.content.Intent intent2 = 
            new android.content.Intent(
                android.content.Intent.ACTION_CALL, 
                android.net.Uri.parse("tel:012345556789"));
    intent2.setFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK); //Add this line, if starting an activity from a service.
    this.startActivity(intent2);
}