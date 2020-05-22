StringBuilder problemDesc = new String....;
    if(inputLine.toLowerCase().startsWith("problem:")){
       problemDesc.append(inputLine);
       while(!inputLine.toLowerCase().startsWith("resolution:"){
           //read next line into inputline;
           problemDesc.append(inputline);
       }
       //deal with problem description here and inputLine now has the line with
       //Resolution in it Repeat same logic for retrieving the resolution value
    }