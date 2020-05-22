Calendar cal  = Calendar.getInstance();
Calendar calAtOne  = Calendar.getInstance();
calAtOne.set(Calendar.HOUR_OF_DAY,13);
calAtOne.set(Calendar.MINUTE,00);
calAtOne.set(Calendar.SECOND,00);

if(calAtOne.after(cal)){
    return calAtOne;
}else{
    cal.add(Calendar.DATE,1);
    cal.set(Calendar.HOUR_OF_DAY,13);
    cal.set(Calendar.MINUTE,00);
    cal.set(Calendar.SECOND,00);
    return cal;
}