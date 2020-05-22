public static void main(String[] args) {
        String content = "sawad";
        String seperator="a";
        String[] s=content.split(seperator);
        int length=s.length;
        System.out.println(length);
        for(int i=0;i<s.length;i++)
        {
            System.out.println(s[i]);
        }


        String [] d=new String[(length * 2) -1];
        for(int i=0;i<s.length;i++)
        {
            d[2*i]=s[i];
            if(i<length-1)
                d[2*(i+1) -1]=seperator;
        }

        System.out.println("------");
        System.out.println(d.length);
        for(int i=0;i<d.length;i++)
        {
            System.out.print(d[i]);
        }
    }