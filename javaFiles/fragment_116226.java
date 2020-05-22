if(attr != null){   
    if(attr.get("cn") != null && attr.get("cn").get(0) != null)
        cn=attr.get("cn").get(0).toString();
    else
        cn = "";
    if(attr.get("uid") != null && attr.get("cn").get(0) != null)
        uid=attr.get("uid").get(0).toString();
    else
        uid = "";
    if(attr.get("mail") != null && attr.get("cn").get(0) != null)
        mail=attr.get("mail").get(0).toString();
    else
        mail = "";
}