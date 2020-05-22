string fooid = Food id // use correct syntax
string barid = Bar id // use correct syntax
string checkstring = "ID=" + fooid + "," + name

rule "test"  
    when   
        barid: String(this not matches "(?i)." + checkstring)  
    then  
        System.out.println(checkstring);  
    end