int linenb=1;//this will hold the current line number
while((nFile=br.readLine())!=null){
    if(linenb>=start&&linenb<=finish)  
        System.out.println(nfile); 
    linenb++;
}
if(linenb<=finish)
    System.out.println("Line not found");