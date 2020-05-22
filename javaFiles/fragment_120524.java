@Override
public void hyperlinkUpdate(HyperlinkEvent arg0) {

        if(arg0.getEventType().toString() == "ACTIVATED")
            System.out.println(arg0.getURL());  
            //openWebpage(arg0.getURL());

}