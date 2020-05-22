NVList argList = orb.create_list (valueMap.size()); 
        for (Map.Entry<String, String> entry : valueMap.entrySet()) {
            Any argument = orb.create_any (); 
            argument.insert_string (entry.getValue()); 
            argList.add_value (entry.getKey().toLowerCase(), argument, org.omg.CORBA.ARG_IN.value); 
        }


        //Result
        Any result = orb.create_any (); 
        result.insert_string( null ); 
        NamedValue resultVal = orb.create_named_value ("result", result, org.omg.CORBA.ARG_OUT.value); 

        //Invoking Method
        Request thisReq = objRef._create_request (null, methodName, argList, resultVal); 
        thisReq.invoke (); 

        //Extract Result
        result = thisReq.result().value ();