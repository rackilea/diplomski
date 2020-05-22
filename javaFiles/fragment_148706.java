import static java.util.stream.Collectors.*;

Map<String,Map<String,Long>> cityCountsByCountry = listOfCities
    .stream()
    .collect(groupingBy(city -> city.parentLocation.name,
                 groupingBy(city -> city.name,
                     counting())));