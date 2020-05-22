interface WorkerThing {
  void doSomething(string lineOfText);
}

class ThatReadsLargeFiles {
    public void readAHugeFile(WorkerThing actions) {
        // TODO write some code to read through the file and store it in line

        // Here you are yielding control to something else
        action.doSomething(line);
    }
 }