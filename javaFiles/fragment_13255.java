try
        {
        a = Integer.parseInt(s1 != null ? s1 : "0");
        b = Integer.parseInt(s2 != null ? s2 : "0");
        c = Integer.parseInt(s3 != null ? s3 : "0");
        d = Integer.parseInt(s4 != null ? s4 : "0");
        }
        catch(NumberFormatException ex)
        {
            System.out.println("Exception : "+ex);
        }