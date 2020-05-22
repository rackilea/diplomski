long startTime = System.currentTimeMillis();
long endTime = startTime + (60*60*1000);

while(System.currentTimeMillis() <= endTime) {
    Command nextCommand = getNextCommandToExecute();
}