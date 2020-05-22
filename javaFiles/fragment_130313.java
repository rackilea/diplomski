try {
            long measureA = System.currentTimeMillis();// You can assign your exact date which is in long format

            Date date = new Date(measureA); 

            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss zzz"); 

            System.out.println(sdf.format(date)); 

            sdf = new SimpleDateFormat("E MMM dd yyyy"); 

            System.out.println(sdf.format(date));

        }catch(Exception e)
        {
            e.printStackTrace();

        }