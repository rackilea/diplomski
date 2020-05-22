Map<String, Boolean> is = new HashMap<String, Boolean>();

...

String qname = "data";
is.put(qname, false);

...

// retrieve is[data] for comparison
if (is.containsKey("data") && is.get("data")) {
    // is[data] is true
}

// update is[data]
is.put("data", true);