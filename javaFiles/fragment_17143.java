class IssueStatus {
   int numOfClosed = 0;
   int numOfResolved = 0;
   int numOfOpen = 0;

   // not sure if status is string or enum
   addStatusCount(String status) {
       // logic to inc the num
       // eg if "closed", then use numOfClosed++
   }

   getNumOfClosed() { return numOfClosed; }
   getNumOfResolved() { return numOfResolved; }
   getNumOfOpen() { return numOfOpen; }
   getTotalIssues() { return numOfClosed + numOfResolved + numOfOpen; }
}