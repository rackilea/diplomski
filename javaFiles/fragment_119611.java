ArrayList<String> arr = new ArrayList<String>();
 for (int i =0; i<len; i++){
     if (thumbnailsselection[i]){
         cnt++;
         ar = nev[i];
         selectImages = nev[i] + "|";             
         arr.add(selectImages); 
     } 
 }

Intent intent = new Intent(Gallery.this,Upload.class);
intent.putStringArrayListExtra("array_list", arr);
startActivity(intent);