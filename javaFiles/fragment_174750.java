public static ServerTask forTaskName(String friendlyTask) {
    for (ServerTask serverTask : ServerTask.values()) {
        if(serverTask.friendlyTask.equals(friendlyTask)) {
            return serverTask;
        }
    }
    return null;
}