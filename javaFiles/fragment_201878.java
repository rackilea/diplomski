BasicDBObject args  = new BasicDBObject();
args.put("ns", nameSpace);
args.put( "initial" , initialDBObject );
args.put( "cond" , queryDBObject );
args.put( "$reduce" , reduceJavasriptCodeString );
args.put("$keyf", keyfJavascriptCodeString );
if( finalize != null ) args.put("finalize", finalizeJavascriptCodeString );
DBObject groupResult = mydbCollection.group(args);