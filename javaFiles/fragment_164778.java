public class ReadJobs {

    public interface Projection extends Serializable {
        interface Job {
            @XBRead("./task")
            List<Task> getTasks();

            @XBRead("./id")
            String getID();
        }

        interface Task {
            @XBRead("./task_id")
            String getID();
        }

        @XBRead("/root/job")
        List<Job> getJobs();
    }

    public static void main(String... args) throws IOException {
        Projection projection = new XBProjector().io().url("res://jobs.xml").read(Projection.class);
        for (Job job : projection.getJobs()) {
            System.out.println(job.getID());
            for (Task task : job.getTasks()) {
                System.out.println(task.getID());
            }
        }
    }
}