BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
i=counter;
while(i<=bandMembers){
System.out.println("Enter band member "+i+" name:-");
String bName=br.readLine();
System.out.println("What instrument does "+bName+" play?");
String bNamePlay=br.readLine();
list = list + i + ":" + " " + bName + " - " + bNamePlay+ "\n";
i++;
}