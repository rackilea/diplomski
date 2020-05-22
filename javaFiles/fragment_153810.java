int limit = 100;
int offset = 0;
do {
     list = readAll(limit, offset);
     int resultSize = list.count(); // Assuming some logic to count

     // do something with list

     // Check for list size vs requested items
     if(resultSize < limit) {
        // Exit loop when number of result retrieved was less than requested items
        break;
     }

     // Else just move on to next batch
     offset += limit;

} while (expression);