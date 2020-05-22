private WorklogEntity workLogEntity;

@OneToOne(mappedBy="workerEntity")
public WorklogEntity getWorkLogEntity() {
    return workLogEntity;
}