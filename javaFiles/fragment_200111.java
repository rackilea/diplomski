String filePath = "D:/Oracle/Middleware/user_projects/domains/ass1/startWebLogic.cmd";
    try 
    {
        Process p = Runtime.getRuntime().exec("cmd /C start D:/Oracle/Middleware/user_projects/domains/ass1/startWebLogic.cmd",null);
    } 

    catch (Exception e) 
    {
        e.printStackTrace();
    }
}