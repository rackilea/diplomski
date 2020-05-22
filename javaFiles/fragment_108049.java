if (!json.isNull("URL"))
{
    // Note, not `getJSONArray` or any of that.
    // This will give us whatever's at "URL", regardless of its type.
    Object item = json.get("URL"); 

    // `instanceof` tells us whether the object can be cast to a specific type
    if (item instanceof JSONArray)
    {
        // it's an array
        JSONArray urlArray = (JSONArray) item;
        // do all kinds of JSONArray'ish things with urlArray
    }
    else
    {
        // if you know it's either an array or an object, then it's an object
        JSONObject urlObject = (JSONObject) item;
        // do objecty stuff with urlObject
    }
}
else
{
    // URL is null/undefined
    // oh noes
}