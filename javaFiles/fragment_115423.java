String s = "@sequence@A:exampleA@B:exampleB";
        String s1= s.substring(1,s.indexOf("@",1));
        System.out.println(s1);
        String s2= s.substring(s1.length()+1);
        System.out.println(s2);
     }