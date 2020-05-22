JsonPrimitive firstHost = new JsonPrimitive("vlbr-vlbre9ef7a820b3f43c7bd3418bb62.uscom-central-1.c9dev1.oc9qadev.com");

JsonArray jArray = new JsonArray();
jArray.add(firstHost);

JsonObject jObj = new JsonObject();
jObj.add("virtual_hosts", jArray);