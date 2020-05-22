case R.id.mainsearch:
 Intent i1 = new Intent("com.example.chequeinfo.SEARCHMAIN");
 i1.putStringArrayListExtra("cheque_list", newlist);

 startActivity(i1);
 break;
}