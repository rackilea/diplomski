Map<String, Integer> movieMap = getMovieMappings("/pathTo/movie_title.txt");
int movieId = movieMap.get(args[2]);
System.out.println(String.format("mv_%06d", movieId));
FileInputFormat.addInputPath( job, 
                              new Path( "training_set",
                                        String.format("mv_%06d", movieId)));