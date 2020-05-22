public void onDataChange(DataSnapshot dataSnapshot)
    {
        Map<String, Job_Class> td = new HashMap<String, Job_Class>()
        for (DataSnapshot jobSnapshot: dataSnapshot.getChildren()) {
            Job_Class job = jobSnapshot.getValue(Job_Class.class);
            td.put(jobSnapshot.getKey(), job);
        }

        ArrayList<Job_Class> values = new ArrayList<>(td.values());
        List<String> keys = new ArrayList<String>(td.keySet());

        for (Job_Class job: values) {
            Log.d("firebase", job.getJobTitle());
        }

    }