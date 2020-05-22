String str = "xxxV iiA gR a xxx";

    if(str.matches("(?i).{0,}v.{0,}i.{0,}a.{0,}g.{0,}r.{0,}a.{0,}")){
        System.out.println("Yes");
    }
    else{
        System.out.println("No");
    }