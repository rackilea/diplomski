for(String arg : args)
{
    if(arg.matches("-no_patching")){
        System.err.println("patching OFF");
        launchApp();
    }
}