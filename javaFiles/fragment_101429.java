public static void main(String[] ar)
    {
        List<String> all=new LinkedList<String>();
        all.add("interpreter");
        all.add("interprete");
        all.add("interpret");
        String small="";
        small=all.get(0);
        for (String string : all) {
            if(small.contains(string))
            {
                small=string;
            }
        }
        System.out.println(small);
    }