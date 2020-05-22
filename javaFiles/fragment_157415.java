public class Cl {

    // We should not have setter for these fields
    private int roll;
    private String s_class; 


    private String name;
    private Date dob;


    @Override
    public int hashCode(){
        return Objects.hash(s_class,roll);
    }

    @Override
    public boolean equals(Object temp){
        if(!( temp instanceof Cl) ){
            return false;
        }
        Cl tempObj = (Cl)temp;

        String s_classTemp = tempObj.s_class;

        if(this.s_class == null && s_classTemp == null){
            return true;
        }

        if(this.s_class == null && s_classTemp != null){
            return false;
        }


        return (tempObj.roll == this.roll) && (this.s_class.equals(tempObj.s_class));
    }
}