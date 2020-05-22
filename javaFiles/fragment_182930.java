mTaskDao.getAllTasks(STATE_ACTIVE)
        .flatMapSingle(task -> 
             Observable.fromIterable(task)
            .map(Task::create)
            .toList()
        )
        .subscribe(
                t -> Log.d(TAG, "getAllActiveTasks: "+t)
        );