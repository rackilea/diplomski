data.stream() // problem in this line 
        .filter(item -> item.getTitle().equals("queryText"))
        .map(movie -> {
        //logic to transform MovieResponse in Movie here
        })
        .collect(Collectors.toList());