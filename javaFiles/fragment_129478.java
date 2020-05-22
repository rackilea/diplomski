try{
       // do your calculation here
       // for your case will be:
            SimpleDateFormat format= new SimpleDateFormat("HH:mm");
            Date date1=format.parse(b);
            Date date2=format.parse(c);
            long difference=date2.getTime()-date1.getTime();
            editText.setText(""+difference);
    }
    catch(ParseException ex){
            System.err.println("ouch!");
    }