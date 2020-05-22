String jsonTxt = "{'lhs': '100 Euros','rhs':'128.551738 Australian dollars','error':'','icc': 'true'}";        
JSONObject json = (JSONObject) JSONSerializer.toJSON( jsonTxt );
System.out.println( "lhs: " + json.getString("lhs") );
System.out.println( "rhs: " + json.getString("rhs") );
System.out.println( "error: " + json.getString("error") );
System.out.println( "icc: " + json.getString("icc") );