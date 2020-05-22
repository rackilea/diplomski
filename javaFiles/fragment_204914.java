import java.io.*;
import java.util.*;
class PREFIXEVAL
{
public static void main(String []args)throws IOException
{
 String p,n="";StringBuffer b;int i,op1,op2;char c;Stack<Integer> s=new Stack<Integer>();
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 System.out.println("enter the prefix expression separated by spaces");
 p=br.readLine();
 i=p.length()-1;
 while(i>=0)
 {
     c=p.charAt(i);
     if(c>=48&&c<=57)
     n=n+c;
     else if(c==' '&&!n.equals(""))
     {/*handles both single and multidigit numbers*/
         b=new StringBuffer(n);b.reverse();n=b.toString();
         s.push(Integer.parseInt(n));n="";
        }
        else 
        {
            if(c=='+')
            {
                op1=s.pop();
                op2=s.pop();
                s.push(op1+op2);
            }
            else if(c=='-')
            {
                op1=s.pop();
                op2=s.pop();
                s.push(op1-op2);
            }
            else if(c=='*')
            {
                op1=s.pop();
                op2=s.pop();
                s.push(op1*op2);
            }
            else if(c=='%')
            {
                op1=s.pop();
                op2=s.pop();
                s.push(op1%op2);
            }
            else if(c=='/')
            {
                op1=s.pop();
                op2=s.pop();
                s.push(op1/op2);
            }
        }
        i--;
    }
    System.out.println("the prefix expression evaluates to "+s.peek());
  }
 }