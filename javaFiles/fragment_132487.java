private fun refreshData(location: String): Flowable<MutableList<WeatherEntry>> {

        return remoteDataSource.getWeatherEntries(location,true).doOnNext({

            // Clear cache
            caches.clear()
            // Clear data in local storage
            localDataSource.deleteAllWeatherEntries()
        }).flatMap(({ Flowable.fromIterable(it) })).doOnNext({ entry ->

            val entryID = localDataSource.insertWeatherEntry(entry)
            entry.wID = entryID
            caches.add(entry)
        }).toList().toFlowable()
    }