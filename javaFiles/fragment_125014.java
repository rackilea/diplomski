static Collector<Object, JSONArray, JSONArray> toJSONArray() {
    return Collector.of(
            JSONArray::new,     // Create a new array
            JSONArray::add,     // Add each element to the target array
            (a1, a2) -> {       // Merge the second array into the first one
                a1.addAll(a2);
                return a1;
            },
            identity()          // Return the populated array itself
    );
}