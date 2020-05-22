if (url.toLowerCase().contains(Dirty1) || url.toLowerCase().contains(Dirty2) || ....)
 {
     Intent intent2 = new Intent(Service_class.this, Warning.class);
     intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
     startActivity(intent2);
     break;
 }