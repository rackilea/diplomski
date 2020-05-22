package so;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class UseIR {
public static void main(String[] args) throws IOException {

//checked using the class provided 'InputReader'
InputReader ob=new InputReader(new FileInputStream(new File("src\\so\\test.txt")));
long str=0;
StringBuilder sb=new StringBuilder();
long curTime=System.currentTimeMillis();
while((str=ob.read())!=-1){
    sb.append(((char)str));
}
System.out.println("done "+(System.currentTimeMillis()-curTime));

//checked using the Scanner class

curTime=System.currentTimeMillis();
Scanner s=new Scanner(new File("src\\so\\test.txt"));
sb=new StringBuilder();
while(s.hasNext()){
    sb.append(s.next());
}
System.out.println("done "+(System.currentTimeMillis()-curTime));
}
}