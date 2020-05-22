// Total pending load is 2
AtomicInteger counter = new AtomicInteger(2);


public void update_data2(){
    SnoTitles2 = new String[fetchedXMLTitles.getTitle().size()];
    for (int i = 0; i < fetchedXMLTitles.getTitle().size(); i++) {      
        SnoTitles2[i] = fetchedXMLTitles.getTitle().get(i); 
    }

    if (counter.decrementAndGet() == 0) {

         // Perform array concatenation here

         concatedArgs = concateString(SnoTitles1, SnoTitles2);
    }
}


public void update_data1(){
    SnoTitles1 = new String[fetchedXMLTitles.getTitle().size()];
    for (int i = 0; i < fetchedXMLTitles.getTitle().size(); i++) {      
        SnoTitles1[i] = fetchedXMLTitles.getTitle().get(i); 
    }

    if (counter.decrementAndGet() == 0) {

         // Perform array concatenation here

         concatedArgs = concateString(SnoTitles1, SnoTitles2);
    }
}