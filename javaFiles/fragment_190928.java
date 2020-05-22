class Item
{
   String name;
   String place;
}



 ArrayList<Item>items=new ArrayList<Item>();




void somemethod()
{

AssetManager assetManager = getAssets();
 InputStream inputStream = assetManager.open("words.xml");

Item item=new Item();
try
        {
             XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
             factory.setNamespaceAware(true);
             XmlPullParser xpp = factory.newPullParser();
             xpp.setInput(inputStream,null);
             int eventType = xpp.getEventType();
             while (eventType != XmlPullParser.END_DOCUMENT) 
             {
                 if(eventType == XmlPullParser.START_DOCUMENT) 
                  { }                 
                 else if(eventType == XmlPullParser.START_TAG)
                 {
                     try 
                     {                          
                             if(xpp.getName()!=null&& xpp.getName().equalsIgnoreCase("name"))
                              {
                                   eventType = xpp.next();
                                   item.name=Integer.parseInt(xpp.getText().toString());
                              }
                             else if(xpp.getName()!=null&& xpp.getName().equalsIgnoreCase("place"))
                              {
                                   eventType = xpp.next();
                                   item.place=xpp.getText().toString();
                              }                     
                        } 
                     catch (Exception e) 
                        {
                            //e.printStackTrace();
                        }
                 }
                 else if(eventType == XmlPullParser.END_TAG) 
                 {
                     if(xpp.getName()!=null&& xpp.getName().equalsIgnoreCase("content"))
                      {
                           eventType = xpp.next();  
                           items.put(item);
                           item=new Item();
                      }
                 }
                 else if(eventType == XmlPullParser.TEXT) 
                 {}
                 eventType = xpp.next();       
         }// end of while                    

        }
        catch (XmlPullParserException e) 
        {
            //e.printStackTrace();
        } 
        catch (IOException e) 
        {
          //e.printStackTrace();
        }
        finally
        {
            try 
            {
                if(inputStream!=null)
                    inputStream.close();
            } catch (IOException e) 
            {               
            }
        }


    }