private static JSONObject toJSONObject(String name, Object value) {
    JSONObject ret = new JSONObject();
    ret.put("name", name);
    if (value != null) {
        ret.put("value", value);
    }
    return ret;
}

public static JSONObject addChildren(JSONObject parent, JSONObject... children) {
    parent.put("children", Arrays.asList(children));
    return parent;
}

public static void main(String[] sargs) {
    JSONObject flare = toJSONObject("flare", null);
    addChildren(flare,
        addChildren(toJSONObject("analytics", null),
            addChildren(toJSONObject("cluster", null),
                toJSONObject("AgglomerativeCluster", 3938),
                toJSONObject("CommunityStructure", 3812)
            ),
            addChildren(toJSONObject("graph", null),
                toJSONObject("BetweennessCentrality", 3534),
                toJSONObject("LinkDistance", 5731)
            )
        ),
        addChildren(toJSONObject("animate", null),
            toJSONObject("Easing", 17010),
            toJSONObject("FunctionSequence", 5842)
        )
    );
    System.out.println(flare.toString());
}