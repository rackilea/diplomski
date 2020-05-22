public class TestComparator {

    static class Process {
        int pid;
        int arrivalTime;

        Process(int pid, int arrivalTime) {
            this.pid = pid;
            this.arrivalTime = arrivalTime;
        }

        @Override
        public String toString() {
            return "Process [pid=" + pid + ", arrivalTime=" + arrivalTime + "]";
        }
    }

    static class FCFSComparator implements Comparator<Process> {
        public int compare(Process o1, Process o2) {
            int result = o1.arrivalTime - o2.arrivalTime;

            if (result == 0) {
                return (o1.pid < o2.pid) ? -1 : 1;
            } else {
                return result;
            }
        }
    }

    public static void main(String[] args) {
        List<Process> processes = Arrays.asList(
                new Process(0, 10),
                new Process(1, 30),
                new Process(2, 15),
                new Process(3, 15),
                new Process(4, 66));

        Collections.sort(processes, new FCFSComparator());

        for (Process process : processes) {
            System.out.println(process);
        }

    }
}