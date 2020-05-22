class GetTasksResponse {
    bool status;
    @SerializedName("doc")
    List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }
}