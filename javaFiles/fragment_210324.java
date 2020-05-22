import net.neoremind.sshxcute.core.SSHExec;
import net.neoremind.sshxcute.core.ConnBean;
import net.neoremind.sshxcute.task.CustomTask;
import net.neoremind.sshxcute.task.impl.ExecCommand;

public class TestSSH {

public static void main(String args[]) throws Exception{

    // Initialize a ConnBean object, parameter list is ip, username, password

    ConnBean cb = new ConnBean("192.168.56.102", "root","hadoop");

    // Put the ConnBean instance as parameter for SSHExec static method getInstance(ConnBean) to retrieve a singleton SSHExec instance
    SSHExec ssh = SSHExec.getInstance(cb);          
    // Connect to server
    ssh.connect();
    CustomTask sampleTask1 = new ExecCommand("echo $SSH_CLIENT"); // Print Your Client IP By which you connected to ssh server on Horton Sandbox
    System.out.println(ssh.exec(sampleTask1));
    CustomTask sampleTask2 = new ExecCommand("sqoop import --connect jdbc:mysql://192.168.56.101:3316/mysql_db_name --username=mysql_user --password=mysql_pwd --table mysql_table_name --hive-import -m 1 -- --schema default");
    ssh.exec(sampleTask2);
    ssh.disconnect();   
}
}