StreamSupport.stream(iterable.spliterator(), false)
             .map(gson::toJsonTree)
             .map(JsonElement::getAsJsonObject)
             .peek(obj -> obj.remove("hash"))
             .collect(of(
                     JsonArray::new,
                     (array, obj) -> array.add(obj),
                     (output, toMerge) -> {
                         output.addAll(toMerge);
                         return output;
                     }
             ));