SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm"); //change format as needed
Date messageDate = formatter.parse(date);
long since = System.currentTimeMillis() - messageDate.getTime();
long seconds = since/1000;
long minutes = seconds/60;
long hours = minutes/60;
long days = hours/24;