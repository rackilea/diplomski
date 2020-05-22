@Path("isDateValid/{itemId}")
public boolean isDateValid(@PathParam("itemId") Long itemId) {
    @QueryParam("begin") String sBegin; 
    @QueryParam("end") String sEnd;

    SimpleDateFormat sdf = new SimpleDateFormat(/* Your patern, for example "yyMMddHHmmssZ"*/);

    Date dBegin = sdf.parse(sBegin);
    Date dEnd = sdf.parse(sEnd);

/*
...
*/
}