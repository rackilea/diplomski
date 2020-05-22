getNews()
        .flatMap { Observable.fromIterable(it.getTopicsList()) } //or Observable.from() if you use RxJava1
        .flatMap({ getNewsImage(it) }, { topic, imageUrl ->
            topic.imageUrl = imageUrl
            return@flatMap topic
        })
        .toList()