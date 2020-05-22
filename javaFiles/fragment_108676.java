public class Assignment7Sasha{
    private static final class Family{
        String lname;
        int income;
    }

    public static void main(String[] args){
        //All variable declarations
        ArrayList families = new ArrayList<Family>();

        //Read into arrays lname, fname and income as you have done

        for(int i = 0; i < 12; i++){
            boolean exists = false;
            Iterator it = families.iterator();
            while(it.hasNext()){     //Check if lname[i] already exists in families
                Family f = (Family)it.next();
                if(f.lname.equals(lname[i])){   //If lname[i] already exists
                    f.income += income[i];
                    exists = true;
                    break;
                }
            }
            if(!exists){     //If lname[i] doesn't exist
                Family f = new Family();
                f.lname = lname[i];
                f.income = income[i];
                families.add(f);
            }
        }

        Iterator it = families.iterator();
        while(it.hasNext()){
            Family f = (Family)it.next();
            //Handle each Family object however you want
            System.out.println("Family:" + f.lname + " Income:" + f.income);
        }
    }