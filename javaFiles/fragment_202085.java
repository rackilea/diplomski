public static void main(String[] args) {  
        //supply your own path instead of using this one 
        String path = "\\image.JPG"; 

        for(;;){

                try{
                    Thread.sleep(1000);
                    SPI.INSTANCE.SystemParametersInfo(     
                    new UINT_PTR(SPI.SPI_SETDESKWALLPAPER),    
                    new UINT_PTR(0),      
                    path,          
                    new UINT_PTR(SPI.SPIF_UPDATEINIFILE | SPI.SPIF_SENDWININICHANGE));
                    }catch(Exception ex){

                    }


          }