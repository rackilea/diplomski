task_location_list =new ArrayList<Task>();
 for (int i = 0; i < locationlist.size(); i++) {
    task_location_list .addAll(db.getAllTasksbyLocation(locationlist.get(i)
                .getAddress()));

    }