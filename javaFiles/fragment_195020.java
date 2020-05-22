ParseQuery<Message> from = ParseQuery.getQuery("Message");
from.whereContainedIn("fromId",list);

ParseQuery<Message> to = ParseQuery.getQuery("Message");
to.whereContainedIn("toId",list);

List<ParseQuery<Message>> queries = new ArrayList<ParseQuery<ParseObject>>();
queries.add(from);
queries.add(to);

ParseQuery<Message> mainQuery = ParseQuery.or(queries);
mainQuery.findInBackground(...);