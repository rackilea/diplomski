private WorkerEntity workerEntity;

@OneToOne
@JoinColumn(name="worker_id")
public WorkerEntity getWorkerEntity() {
    return workerEntity;
}