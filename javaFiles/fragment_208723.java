LocalDateTime end = null;
try{
 MatchResult mr =sc.match();
 int month = Integer.parseInt(mr.group(2));
 int day = Integer.parseInt(mr.group(1));
 int hour = Integer.parseInt(mr.group(3));
 int minute = Integer.parseInt(mr.group(4));
 end = LocalDateTime.of(year, month, day, hour, minute);
 //System.out.println(end);
} catch (IllegalStateException e){
   System.err.println("Invalid input!");
}

Performer performer = new Performer(bandname, kind, start, end , stage);

listperformer.add(performer);
return listperformer;