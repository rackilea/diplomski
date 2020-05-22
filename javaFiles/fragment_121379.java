int noOfWorkItem = 0;
while((bytesRead = inBytes.read(buff)) != -1) {
   System.arraycopy(buff, BLOCK_SIZE-DICT_SIZE, dict, 0, DICT_SIZE);
   worker = new WorkerThread(buff, dict, noOfWorkItem++)   
   tpes.execute(worker);
}