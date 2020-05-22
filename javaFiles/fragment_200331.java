import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Multipleprocess {

public static void main(String[] args)throws Exception {
int process=0;
String s[]={"/bin/sh","-c","cat /etc/*-release" };
Process p=Runtime.getRuntime().exec(s);
BufferedReader proc=new BufferedReader(new InputStreamReader(p.getErrorStream()));
BufferedReader pout=new BufferedReader(new InputStreamReader(p.getInputStream()));
// We read stderror first from String because it spits the progress information 
//into   stderr

for (String s1=proc.readLine(); s1!=null; s1=proc.readLine())
{
process++;
System.out.println("Stderr from p: "+s);
}
for (String s1=pout.readLine(); s1!=null; s1=pout.readLine())       
{
process++;
System.out.println("Stdout from p: "+s);
}

//how many process have completed check here 
System.out.println("process have completed"+process);
// if you need to check whether the command actually returned normally

int returnCode = p.waitFor();
proc.close();
pout.close();

System.out.println("Process exited with return code "+returnCode);
}
}