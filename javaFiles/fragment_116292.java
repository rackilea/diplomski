String str = "<xml>blalbalblal asfjñs" + "fasdf" 
                    +   "iduser=dmengelblack; name=angel; lastname=uc;"
                    +   "blablal"
                    +   "iduser=cccarlos; name=carlos; lastname=uc;";
        List<String> iduser = new ArrayList<String>();
        List<String> name = new ArrayList<String>();
        List<String> lastname = new ArrayList<String>();
        int i = 1;
        while(str.indexOf("iduser=", i) > 0) {
            i=str.indexOf("iduser=",i);
            iduser.add(str.substring(i, str.indexOf(";", i)));
            name.add(str.substring(str.indexOf("name=", i), str.indexOf(";", str.indexOf("name=", i))));
            lastname.add(str.substring(str.indexOf("lastname=", i), str.indexOf(";", str.indexOf("lastname=", i))));
            i=str.indexOf("lastname=",i);
        }
        System.out.println(iduser);
        System.out.println(name);
        System.out.println(lastname);