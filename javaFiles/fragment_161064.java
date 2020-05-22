confirmdatebtn1.setOnAction(new EventHandler<ActionEvent>(){
                   @Override public void handle(ActionEvent e) {
                        filterData.setPredicate(table -> {
                            if ((todatetxt.getText() == null &&fromdatetxt.getText() == null) ||
                                    (todatetxt.getText().isEmpty()&&fromdatetxt.getText().isEmpty()) ) {
                                return true;}
                try {
                        String fromtext = fromdatetxt.getText();
                        String totext = todatetxt.getText();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                        Date date1 = null;
                        Date date2 = null;
                        Timestamp timestamp1 = null;
                        Timestamp timestamp2 = null;

                        if(todatetxt.getText().isEmpty() && !fromdatetxt.getText().isEmpty()) {
                                date1 = format.parse(fromtext+" 00:00:00.000");
                                timestamp1 = new java.sql.Timestamp(date1.getTime());
                                if (table.getTime_of_action().after(timestamp1) ) 
                                {return true;}
                        }
                        if(!todatetxt.getText().isEmpty() && fromdatetxt.getText().isEmpty()) {
                            date2 = format.parse(totext+" 23:59:59.000");
                            timestamp2 = new java.sql.Timestamp(date2.getTime());
                            if (table.getTime_of_action().before(timestamp2) ) 
                            {return true;}
                        }
                        if(!todatetxt.getText().isEmpty()  && !fromdatetxt.getText().isEmpty()) {
                            date1 = format.parse(fromtext+" 00:00:00.000");
                            date2 = format.parse(totext+" 23:59:59.999");

                            timestamp1 = new java.sql.Timestamp(date1.getTime());
                            timestamp2 = new java.sql.Timestamp(date2.getTime());

                            if (table.getTime_of_action().before(timestamp2) &&table.getTime_of_action().after(timestamp1)) 
                            {return true;}
                        }

                    } catch (Exception e1) {

                    }

                        return false; 
            });} });*** i wrote this code and it came out good so my probleme is resolved thanks to your help guys***