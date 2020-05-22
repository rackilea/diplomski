long count = Files.lines(Paths.get(file))
    .map(line -> line.split("=", 2))
    .filter(array -> array.length == 2)
    .filter(array -> 
          (array[0].trim().equals("User name") && array[1].trim().equals(userName))
       || (array[0].trim().equals("Password")  && array[1].trim().equals(password))
    )
    .count();
if (count == 2) ...