ArrayList listObjects = new ArrayList();
Scanner input = new Scanner(System.in);        
Stack st = new Stack();
while(input.hasNext()){
    String tkn =  input.next();
    st.push(tkn);           
    if (st.size()==3){
         int y = Integer.parseInt((String)st.pop());
         int x = Integer.parseInt((String)st.pop());
         String name = (String)st.pop();
         //create and add the object to the list for further use
         listObjects.add(new MyObject(name, x, y));
         System.out.println("name="+name+",x="+x+",y="+y);

     }
 }