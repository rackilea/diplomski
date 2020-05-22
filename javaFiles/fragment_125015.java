@SupressWarnings("unchecked")
final Collection<JSON> jsonArray = (Collection<JSON>) originalJsonArray;
final JSONArray flatJSONArray = jsonArray.stream()
        .map(json -> (Map<?, ?>) json)          // All outer array elements are JSON objects and maps in particular
        .map(jsonObject -> jsonObject.values()  // Recursively flatten the JSON object values
                .stream()
                .flatMap(Q43481457::flatten)
                .collect(toJSONArray())         // ... collecting them to JSON arrays
        )
        .collect(toJSONArray());                // ... which are collected to JSON arrays
System.out.println(flatJSONArray);