webService.getByLastUpdate(syncPreferences.getLastDownloadDate())
    .flatMapCompletable(response ->
        repository
            .insert(response.data)
            .doOnComplete(() ->
                syncPreferences.setLastDownloadDate(response.timeStamp)
            )
    );