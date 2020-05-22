String myjson = "{\"elements\": [{\"text\":\"Obj1\"},{\"text\":\"Obj2\"}, {\"text\":\"Obj3\"}]}";

    Observable.just(myjson)
            .map(jsonStr -> new StringReader(myjson))
            .map(reader -> Json.createReader(reader).readObject())
            .map(jobj -> jobj.getJsonArray("elements"))
            .map(elements -> elements.toArray(new JsonObject[elements.size()]))
            .flatMap(jsonObjects -> Observable.from(jsonObjects))
            .subscribe(
                    (jsonObject) -> System.out.println(jsonObject.getString("text")),
                    throwable -> throwable.printStackTrace(),
                    () -> System.out.println("On complete"));