boolean error=false;
            while (!error && (i<1000)) {
                //...                   
                writer.write("data: " + /*... + */  "\n\n");
                //writer.flush();
                error = writer.checkError();    //internally calls writer.flush()
                //... 
            }