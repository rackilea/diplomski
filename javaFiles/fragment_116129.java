public List<Pelicula> unmarshal(String xml) throws Exception{           
        List<Pelicula> peliculas = new ArrayList<Pelicula>();       
        InputStream is = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        XmlPullParser parser = Xml.newPullParser(); 
        char[] c;
        String id="", titulo="", poster="", atributo="";
        int datos =0;
        try{ 
            parser.setInput(is, "UTF-8"); 
            int event = parser.next();  
        while(event != XmlPullParser.END_DOCUMENT) { 
            if(event == XmlPullParser.START_TAG) { 
                Log.d(TAG, "<"+ parser.getName() + ">"); 
                atributo = parser.getName();
                for(int i = 0; i < parser.getAttributeCount(); i++) { 
                    Log.d(TAG, "\t"+ parser.getAttributeName(i) + " = "+ parser.getAttributeValue(i)); 
                } 
            } 
            if(event == XmlPullParser.TEXT&& parser.getText().trim().length() != 0) 
            {
                Log.d(TAG, "\t\t"+ parser.getText());
                if (atributo=="id"){id=parser.getText(); datos++;}
                else if(atributo=="titulo"){titulo=parser.getText(); datos++;}
                else if(atributo=="poster"){poster=parser.getText(); datos++;}
                if(datos==3){peliculas.add(new Pelicula(id, titulo, poster)); datos=0;} 
            }
                if(event == XmlPullParser.END_TAG) 
                    Log.d(TAG, "</"+ parser.getName() + ">");               
                event = parser.next(); 

            is.close();
        }
        } catch(Exception e) { Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show(); }        
        for (Pelicula p : peliculas){
            Log.d("Película en lista: ", p.titulo);
        }           
        return peliculas;
    }