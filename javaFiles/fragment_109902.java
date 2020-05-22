String json = "{par_a:.....,par_b: [ {b1:.....,b2:.....,b3:.....,b4:.....,b5:.....,b6:.....,b7:.....,b8:.....,b9:.....,b10: { b10-1:....., b10-2:....., b10-3:..... } ,b11: { b11-1: [..... ], b11-2: [..... ] } , b13:.......} ]}";

try{
    String result = new JSONObject(json).getJSONArray("par_b").getJSONObject(0).getJSONObject("b_10").getString("b10-1");
}catch(Exception e){

}