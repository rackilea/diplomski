public interface JobData<T> {
    T getData();
}

public interface JobStatus<T extends JobData> {
    T getJobData();
}

public class Service {

    private Map<Long, JobStatus> jobStatusMap;

    public <T extends JobData> List<JobStatus<T>> getJobsByJobDataType(Class<T> clazz) {
        return jobStatusMap.values().stream()
                .filter(value -> clazz.isAssignableFrom(value.getJobData().getClass()))
                .map(value -> (JobStatus<T>) value)
                .collect(Collectors.toList());
    }
}