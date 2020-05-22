for(int i = 0; i<list_apps.size(); i++)
    {
        html+="<td>"+list_apps.get(0).toString() +"</td>";//username
        html+="<td>"+list_apps.get(1).toString() +"</td>";//appname
        html+="<td>"+list_apps.get(2).toString() +"</td>";//ip
        html+="<td>"+list_apps.get(3).toString() +"</td>";//token
        html+="<tr>";
    }