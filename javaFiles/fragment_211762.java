String genreList = "";

for (int i = 0; i < movies.length; i++)
  {
     if(movies[i].getMovieGenre().equalsIgnoreCase("action") && movies[i].getMovieGenre().equalsIgnoreCase(genreID))
     {
        genreList += movies[i].getMovieID() + " - " + movies[i].getMovieTitle() + "[" + movies[i].getMediaType() + "]\n";
     }
     else if(movies[i].getMovieGenre().equalsIgnoreCase("childrens") && movies[i].getMovieGenre().equalsIgnoreCase(genreID))
     {
        genreList += movies[i].getMovieID() + " - " + movies[i].getMovieTitle() + "[" + movies[i].getMediaType() + "]\n";         
     }
     else if (movies[i].getMovieGenre().equalsIgnoreCase("drama") && movies[i].getMovieGenre().equalsIgnoreCase(genreID))
     {
        genreList += movies[i].getMovieID() + " - " + movies[i].getMovieTitle() + "[" + movies[i].getMediaType() + "]\n";            
     }
     else
     {
     } 

  }

if (genreList.equals(""))
{
  genreList = "No rental movies were found for the genre: " + genreID;
}