File pdfFile = new File(path); 
        if(pdfFile.exists()) 
        {

            Uri path = Uri.fromFile(pdfFile); 
            Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
            pdfIntent.setDataAndType(path, "application/pdf");
            pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            try
            {
                startActivity(pdfIntent);
            }
            catch(ActivityNotFoundException e)
            {
                Toast.makeText(uractivity.this, "File does not exist", Toast.LENGTH_LONG).show(); 
            }
        }