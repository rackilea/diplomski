ArrayList<Connection> con = new ArrayList<Connection>();
       
        
     
     
        
   public class Connection     {
    private NamedShape namedShape1;
    private NamedShape namedShape2;
    public Connection(NamedShape namedShape1,NamedShape namedShape2){
        this.namedShape1 = namedShape1;
        this.namedShape2 = namedShape2;
    }
    
    public NamedShape getNamedShape1(){
        return namedShape1;
    }
    public NamedShape getNamedShape2(){
        return namedShape2;
    }
    
    public void setNameShape1(){
        this.namedShape1 = namedShape1;
    }
    
    public void setNameShape2(){
        this.namedShape2 = namedShape2;
    }
   }