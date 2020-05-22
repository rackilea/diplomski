public class JobGroupMod implements JobGroup {

    public static JobGroupMod createModeMod(Node n, Set<Job> clusterJobs) {
        JobGroup jg = new JobGroupMod();
        JobMod j = new JobMod(n, jg);
        return jg;
    }
}