//dvdList is now passed to the method.
public static void main(String[] args) {
    ArrayList<DVDInfo>  dvdList= new ArrayList<DVDInfo>();
    try{
        populateList(dvdList);
    }catch(Exception e){
        System.out.println("Exception caught"+e.getMessage());
    }
    System.out.println(dvdList);
}