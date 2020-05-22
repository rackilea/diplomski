StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());

long bytesAvailable = (long)stat.getBlockSize() *(long)stat.getBlockCount();
long megAvailable   = bytesAvailable / 1048576;

System.out.println("Megs :"+megAvailable);