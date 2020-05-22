public class YourClass {

private String url;

public void yourMethod {
   url = getURL(serverquery);
   System.out.println("URl is "+serverquery);
   item.setLabel(URL+item.getLabel());
   Thread t = new Thread() {
      public void run() {
         item.setLabel(item.getLabel()+"6");
         try {
           Image image = loadImage(url);            // using url
           System.out.println("GEtting image....");
           item = new ImageItem(null, image, 0, null);
           form.append(item);
           display.setCurrent(form);

    } catch (IOException ioe) {
      item.setLabel("Error1");
    }
                catch (Exception ioe) {
      item.setLabel("Error1");
    }

  }
};
t.start(); // write post-action user code here
}