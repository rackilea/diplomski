while (imageIter.hasNext())
{
     String key = (String) imageIter.next();
     PDXObjectImage pdxObjectImage = (PDXObjectImage) pageImages.get(key);
     System.out.println(totalImages);
     pdxObjectImage.write2file("C:\\SOMEPATH\\" + fileName + "_" + totalImages);
     totalImages++;

     //break;
 }