SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse("2012-05-17");
            Date date2 = sdf.parse("2012-01-01");

            System.out.println(sdf.format(date1));
            System.out.println(sdf.format(date2));

            if(date1.compareTo(date2)>0){
                System.out.println("Date1 is after Date2");
            }else if(date1.compareTo(date2)<0){
                System.out.println("Date1 is before Date2");
            }else if(date1.compareTo(date2)==0){
                System.out.println("Date1 is equal to Date2");
            }