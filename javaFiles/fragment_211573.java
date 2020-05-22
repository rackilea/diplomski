/* You may found some shortcuts for this
       but following code is easy to understand 
    */
    String[] array = { "CC/2", "DDD/3", "AAAA/4", "B/1"};
    Arrays.sort(array, new Comparator<String>() {

        public int compare(String o1, String o2) {
            int i1,i2;
            /* 
               You should add some checks like 
               1] null check
               or 
               2] whether String contains / or not etc before going for further 
               code.
            */
            /* Get Numbers from String To compare */
            i1=Integer.valueOf(o1.split("/")[1]);
            i2=Integer.valueOf(o2.split("/")[1]);
            //May throw NumberFormatException so be careful with this

            if(i1>i2)
                return 1;
            else if(i1<i2)
                return -1;
            else
                return 0;
        }
    });
    System.out.println(Arrays.toString(array));//Print array