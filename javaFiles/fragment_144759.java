public class Mapper  {      
  public static void main(String[] args) throws ParseException {

      /*Date Calculation*/
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
      String dateOfDeparture = "31-08-1982 10:20:56";
      String dateOfArrival = "31-08-1983 10:20:56";         
      Date date1 = dateFormat.parse(dateOfDeparture);
      Date date2 = dateFormat.parse(dateOfArrival);


      /*set values to Source object*/
      OrikaMapFrom objectMapFrom  = new OrikaMapFrom();
      OrikaMapTo objectMapTo = new OrikaMapTo();
      objectMapFrom.setSource("Delhi"); 
      objectMapFrom.setDestination("Amsterdam");
      objectMapFrom.setDateOfDeparture(date1);
      objectMapFrom.setDateOfArrival(date2);

      /*Name Mapping when source and destination names are different*/
      MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build(); 
      mapperFactory.classMap(OrikaMapFrom.class, OrikaMapTo.class)
        .field("source", "sourcePlace")
        .field("destination","destinationPlace")
        .customize(new CustomMapper<OrikaMapFrom,OrikaMapTo>() {
            @Override
            public void mapAtoB(OrikaMapFrom a, OrikaMapTo b, MappingContext mappingContext) {
               long diff = a.getDateOfArrival().getTime() - a.getDateOfDeparture().getTime();
               b.setTravelDuration((int)TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

            }
        })
        //.field(noOfDays,"travelDuration")--------------->facing error on this line
        .register();

      /*Value Mapping*/  
      MapperFacade mapper = mapperFactory.getMapperFacade();
      objectMapTo = mapper.map(objectMapFrom, OrikaMapTo.class);
      objectMapTo.setTravelDuration(noOfDays);

        System.out.println(objectMapTo.getSourcePlace());
        System.out.println(objectMapTo.getDestinationPlace());
        System.exit(0); 
    }
}