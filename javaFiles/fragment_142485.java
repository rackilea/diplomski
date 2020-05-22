InputStream inputXml = null;
    try
    {



             inputXml  = new URL("http://weather.yahooapis.com/forecastrss?w=12718298&u=c").openConnection().getInputStream();



       DocumentBuilderFactory factory = DocumentBuilderFactory.
                                        newInstance();
       DocumentBuilder builder = factory.newDocumentBuilder();
       Document doc = builder.parse(inputXml);
       NodeList nodi = doc.getElementsByTagName("yweather:forecast");

       if (nodi.getLength() > 0)
       {


          Element nodo = (Element)nodi.item(0);

          String strLow = nodo.getAttribute("low");
          Element nodo1 = (Element)nodi.item(0);
          String strHigh = nodo1.getAttribute("high");
          System.out.println("Temperature low: " + strLow);
          System.out.println("Temperature high: " + strHigh);

        }
    }
    catch (Exception ex)
    {
       System.out.println(ex.getMessage());
    }
    finally
    {
       try
       {
          if (inputXml != null)
          inputXml.close();
       }
       catch (IOException ex)
       {
          System.out.println(ex.getMessage());
       }
    }
 }