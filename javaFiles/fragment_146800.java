String sortParams="";
String findParams = "";
String returnParams="";
//if sort is there then this keyword will be there
String sortStr = "sort";
//if return params exist then only the below substring will be there
String retStr="]},{";

//remove extra spaces in the query
        query = query.replaceAll(" ", "");

        if(query.contains(sortStr))
        {

             sortParams = query.substring(query.lastIndexOf(sortStr)+5, query.lastIndexOf(")"));

             query = query.substring(0, query.lastIndexOf(sortStr)-1);
        }

        if(query.contains(retStr))
        {
            returnParams =   query.substring(query.lastIndexOf(retStr)+3, query.length()-1);

            query = query.substring(0, query.lastIndexOf(retStr)+2)+")";
        }

         findParams = query.substring(query.indexOf("(")+1, query.length()-1);