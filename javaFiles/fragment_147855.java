StringBuffer encodeString = new StringBuffer();

String encode = Geo_Class.encodeSignedNumber(3850000)+""+Geo_Class.encodeSignedNumber(-12020000);                       
encodeString.append(encode);
encode = Geo_Class.encodeSignedNumber(220000)+""+Geo_Class.encodeSignedNumber(-75000);                      
encodeString.append(encode);
encode = Geo_Class.encodeSignedNumber(255200)+""+Geo_Class.encodeSignedNumber(-550300);                     
encodeString.append(encode);

Log.v("encode string", encodeString.toString());