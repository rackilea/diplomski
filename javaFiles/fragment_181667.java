Intent prnIntent = new Intent(Intent.ACTION_SEND);
prnIntent.putExtra(Intent.EXTRA_STREAM, uri);

prnIntent.setType("application/pdf");


startActivity(Intent.createChooser(prnIntent , "Send pdf using:"));