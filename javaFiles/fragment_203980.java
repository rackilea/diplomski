if(!uri.contains("https://www.facebook.com/")) {  
              String natgeo = "natgeo";  
              String uri = "fb://Page/" + natgeo;      
              Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));  
              startActivity(intent);     
              }  
              else{  
              String natgeo = "natgeo";  
              String uri = "https://www.facebook.com/" + natgeo;    
              Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));      
              startActivity(i);   
    }