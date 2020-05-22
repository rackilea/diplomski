public class justcheckin {
static String[] l = {"a","a","b","a","a"};

public class notAexception extends Exception{

    private static final long serialVersionUID = 1L;

    notAexception (){
        super();
    }
    notAexception(String message){
        super(message);
    }
}

private  void loop () throws notAexception {
    notAexception b = new notAexception("not an a");
    for (int i = 0; i< l.length; i++){
        try{
            if (! l[i].equals("a")){
                throw b;
            }
        }catch(notAexception ne){
            System.out.println("index "+i+" is not a");//index 2 is not a
        }
    }
}

public static void main (String[] args) throws notAexception{
    justcheckin a = new justcheckin();
    a.loop();
}
  }