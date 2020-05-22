@Embeddable
class TaskPKId  implements Serializable {
        long taskId;
        long taskTypeId;
        @Column(name="STORY_ID")
        long storyId;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public void setTaskTypeId(long taskTypeId) {
        this.taskTypeId = taskTypeId;
    }
}