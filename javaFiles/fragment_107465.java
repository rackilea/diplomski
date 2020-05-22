proRepo.loadUser(prefSource.userId)
                .flatMap { Flowable.fromIterable(it) }
                .groupBy { it.typePro } // <- group by profile type
                .flatMap { group ->
                    group.collect({ ArrayList<ProItem>() }, { profiles, profile ->
                        profiles.add(profile) //<- get profiles of one type    
                    }).map { 
                           MyProWrap(type = group.key!!, profiles = it) //<- wrap result
                       }.toFlowable()
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                           result = it 
                          },{ 
                            Timber.e("Fail to load profiles. ${it.message}") 
                          })