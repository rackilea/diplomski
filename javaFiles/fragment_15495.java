Person maxPerson = people.get(0); // get's the first person
 for(int i = 1; i < people.size(); i ++) // loop over list, finding max
 {
    if(people.get(i).getFloatValue() > maxPerson.getFloatValue())
       maxPerson = people.get(i); 
 }
 // now maxPerson stores the person where this value is the highest