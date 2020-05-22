String date="2016/04/26";
    Date enteredDate=null;
    try
    {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    enteredDate = sdf.parse(date);
    }catch (Exception ex)
    {
        // enteredDate will be null if date="287686";
    }
    Date currentDate = new Date();      
    if(enteredDate.after(currentDate)){
        System.out.println("after ");
    }else
        System.out.println("before");