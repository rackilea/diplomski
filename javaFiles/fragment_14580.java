DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
Date date = new Date();

JFrame jFrame= new JFrame("Current Date: "+dateFormat.format(date));

or 

jFrame.setTitle("Current Date"+dateFormat.format(date));