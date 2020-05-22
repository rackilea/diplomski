SimpleDateFormat sdf = new SimpleDateFormat ("dd/Mm/yyyy hh:mm:ss aa");

long unixTimeInSeconds = jsonChildNode.getLong("date");

item.put("date",sdf.format(new Date(unixTimeInSeconds * 1000L)));


Log.d("tag",sdf.format(new Date(unixTimeInSeconds * 1000L)));