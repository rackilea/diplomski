Iterator imageIter = pageImages.keySet().iterator();
 while (imageIter.hasNext())
 {
     String key = (String) imageIter.next();
     Object o = pageImages.get(key);
     if (o instanceof PDXObjectImage)
     {
         PDXObjectImage pdxObjectImage = (PDXObjectImage) o;

         // do stuff
     }
 }