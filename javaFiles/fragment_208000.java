List<Future<Person>> personFutures = new ArrayList<Future<Person>>();
BufferedReader reader = 
    new BufferedReader(new InputStreamReader(getInputStream(), "UTF-16"));

while((line = reader.readLine()) != null) {
   PersonParser parser = new PersonParser(line);
   personFutures.add(Futures.future(parser, system.dispatcher()));
}
reader.close();

Future<Iterable<Person>> personsFuture = 
    Futures.sequence(personFutures, system.dispatcher());