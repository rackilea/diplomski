val observableList = mutableListOf<Maybe<Response>>()
...
if (post.type == SomeType) {
      observableList.add(addNewObservable().toMaybe())
}
...
return Maybe.zip(observableList) { arg -> arg }