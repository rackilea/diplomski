public class Process implements Comparable<Process>{

    @Override
    public int compareTo(Object o) {
        Process p2 = (Process) o;
        if(this.priority > p2.priority){
          return 1;
        }else if(this.priority < p2.priority){
          return -1;
        }
        return 0;
    }
}