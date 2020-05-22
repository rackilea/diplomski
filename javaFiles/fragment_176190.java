String text, html;
BufferedReader br;
int i;int tags=0;

br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter HTML code");//If you want to read ferom file, replace the code
html=br.readLine();
for(i=0;i<html.length();i++){
if(html.charAt(i)=='<'){tags++;continue;}
if(html.charAt(i)=='>'){tags--;continue;}
if(tags==0)text=text+html.charAt(i);
}