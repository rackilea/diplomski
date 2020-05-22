JSONObject potentialObject=response.getJsonObject("resuslt")
.getJsonObject("Potentials");

// here use opt. if the object is null, it means its not the type you specified
JSONObject row=potentialObject.optJsonObject("row");
if(row==null){
    // row is json array .
    JSONArray rowArray=potentialObject.getJsonArray("row");
    // do whatever you like with rowArray
} else {
    // row is json object. do whatever you like with it
}