while (true){
    boolean swapped = false;
    for (int i =1;i<files.length;i++) {
        Date lastModdate1 = new Date(files[i-1].lastModified());
        Date lastModDate2 = new Date(files[i].lastModified());
        if(lastModdate1.compareTo(lastModDate2)>1){
              swap(files,i-1,i);
              swapped = true;
        }
    }
    if ( !swapped )
      break;
}