private final Object lock = new Object(); // dedicated lock object
//... _recordIdsSent, addSentRecordIds etc...
public void deleteRecords()
{
    List<Long> ids;
    synchronized (lock) {
        ids = (List<Long>) _recordIdsSent.clone();
        _recordIdsSent.clear();
   }

   // Delete the records matching ids....
}