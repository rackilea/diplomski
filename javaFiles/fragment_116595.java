if (sm[i] instanceof Hourly) {

       /* .... */
       }else if (sm[i] instanceof Commission) {
            Commission c = (Commission) sm[i];
            if(c.name.equals("Molly")){
                c.addHours(55);
                c.addSales(400);
            }else if(c.name.equals("Joe")){
                c.addHours(45);
                c.addSales(950);
            }
       }