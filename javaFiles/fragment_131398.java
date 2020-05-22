Oservable
.fromArray(observableList)
.flatMapIterale(i -> i)
.flatMap(i -> i)
.doOnNext(t -> {
   Gson jsonBuilder = new Gson();
   Object obj = new Object();
   JsonElement element = jsonBuilder.toJsonTree(obj);
   element.getAsJsonObject().addProperty(t.get(0), t.get(1));
   Gson g = new Gson();
   Object out = g.fromJson(t.get(1), Object.class);
   microResponses.put(t.get(0), out);
})
// .subscribe(...) or .doOnComplete(...).subscribe();
;