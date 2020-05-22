public void onClick(View v) 
{
          Intent intent = new Intent();
          intent.setAction(android.content.Intent.ACTION_VIEW);
          File file = new File("/sdcard/ReportData.txt");
          intent.setDataAndType(Uri.fromFile(file), "text/*");
          startActivity(intent); 
}