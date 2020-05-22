public static void main(String[] args) {

        List<Object[]> items = new ArrayList<Object[]>();

        String [] item  = new String[5];
        item[0]="saurabh";
        item[1]="Kumar";
        item[2]="Singh";


        items.add(item);

        for(Object[] d:items){
            System.out.println(Arrays.toString(d));
        }

    }