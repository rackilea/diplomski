genre = genreList.get(count);
    for (String g : genre.keySet()) {
      if (genres.contains(g)) {
        // Now get the ARGB value associated with the genre
        argbColor = genre.get(g);
        return argbColor;
      }
    }