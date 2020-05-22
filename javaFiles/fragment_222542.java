String movieRuntime;
if (!movies.containsKey("runtime")) {
    movieRuntime="*Not Available*";
} else if (movies.get("runtime") instanceof Integer){
    movieRuntime = String.valueOf(movies.get("runtime"));
}
// add an else case for all the other types