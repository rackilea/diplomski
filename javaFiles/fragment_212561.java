@Repository
public class JobEntityDao {
    public List<JobEntity> findAll() {
        List<JobEntity> list = new ArrayList<JobEntity>();

        JobEntity job1 = new JobEntity("0 0 12 * * ?");
        JobEntity job2 = new JobEntity("0 15 10 ? * *");
        JobEntity job3 = new JobEntity("0 15 10 * * ?");

        list.add(job1);
        list.add(job2);
        list.add(job3);

        return list;
    }
}