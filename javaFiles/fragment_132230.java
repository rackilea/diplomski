//initially set success
 result.setstatus("success");
 for(int i = 0;i < work.length;i++){ 
if(!work[i].contains("#")){                          
    CommandLineInterface CLI = new CommandLineInterface();
    String IP = null;


    try {                       
       if(CLI.Setting(work[i],"start"))
         {
         result.setstatus("fail");
           //no need to iterate further
           break;
        }                                 
    } catch (JSchException | InterruptedException e) {
        e.printStackTrace();
    }       
}