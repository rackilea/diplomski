ConnBean cb = new ConnBean(buildServerURL, buildServerUsername,buildServerPassword);
    // Put the ConnBean instance as parameter for SSHExec static method getInstance(ConnBean) to retrieve a singleton SSHExec instance
    ssh = SSHExec.getInstance(cb);          
    //Connect to server
    ssh.connect();
    CustomTask sampleTask = new ExecCommand("/usr/init/checkout.sh");
    //Execution of main taks
    Result rs = ssh.exec(sampleTask);
    int exitCode = rs.rc; //rc stands for result code, and this rc will have what shell returned.rc is not a function but a int variable of Result class.
    if(exitCode!=0){
      //Error message
}else 
     //Success message.