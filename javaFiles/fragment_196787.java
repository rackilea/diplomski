Pattern p = Pattern.compile("\\d*");
     String [] array=new String[]{"23","33.23","4d","ff"};
     List<String> lst=new ArrayList<String>();
            for (int i=0; i<array.length; i++) {
                if(p.matcher(array[i]).matches()){
                    lst.add(array[i]);
                }
            }
     System.out.println(""+lst);