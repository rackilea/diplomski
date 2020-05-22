for(int i = 0; i<list_apps.size(); i+=4)
    {
        html+="<td>"+list_apps.get(i).toString() +"</td>";//username
        html+="<td>"+list_apps.get(i+1).toString() +"</td>";//appname
        html+="<td>"+list_apps.get(i+2).toString() +"</td>";//ip
        html+="<td>"+list_apps.get(i+3).toString() +"</td>";//token
        html+="<tr>";
    }