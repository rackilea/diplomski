package teteo;

public class TestAddressBook {

    public static void main(String[] args) {

        System.out.println("ENTRY 1");

        AddressBook entry1 = new AddressBook("Robert", "James", "Smith", "3 Fake St", 
                                             "222-321-8371", "222-423-2382", 
                                             "222-438-2918", "bob483", "bobfb493",
                                             "http://www.freewebhost.com/bob848");

        System.out.println( "First Name:        " + entry1.getFirstName() );
        System.out.println( "Middle Name:       " + entry1.getMiddleName() );
        System.out.println( "Last  Name:        " + entry1.getLastName() );
        System.out.println( "Address:           " + entry1.getHomeAddress() );
        System.out.println( "Home Phone:        " + entry1.getHomePhone() );
        System.out.println( "Cell Phone:        " + entry1.getCellPhone() );
        System.out.println( "Business Phone:    " + entry1.getBusinessPhone() );
        System.out.println( "Skype ID:          " + entry1.getSkypeId() );
        System.out.println( "Facebook ID:       " + entry1.getFacebookId() );
        System.out.println( "Personal Website:  " + entry1.getPersonalWebSite() );

        System.out.println("\nENTRY 2");

        AddressBook entry2 = new AddressBook("Robert", "James", "Smith", "56 Outtamy Way", 
                                             "564-342-8372", "564-283-9832", 
                                             "564-293-3489", "brucie392", "brucieface28",
                                             "http://www.freewebhost.com/carteristheman");

        System.out.println( "First Name:        " + entry2.getFirstName() );
        System.out.println( "Middle Name:       " + entry2.getMiddleName() );
        System.out.println( "Last  Name:        " + entry2.getLastName() );
        System.out.println( "Address:           " + entry2.getHomeAddress() );
        System.out.println( "Home Phone:        " + entry2.getHomePhone() );
        System.out.println( "Cell Phone:        " + entry2.getCellPhone() );
        System.out.println( "Business Phone:    " + entry2.getBusinessPhone() );
        System.out.println( "Skype ID:          " + entry2.getSkypeId() );
        System.out.println( "Facebook ID:       " + entry2.getFacebookId() );
        System.out.println( "Personal Website:  " + entry2.getPersonalWebSite() );

        System.out.println("\nENTRY 3");

        AddressBook entry3 = new AddressBook("Susan", "Anne", "Peters", "6 Madeup Blvd", 
                                             "736-453-1238", "736-392-2385", 
                                             "736-926-2439", "anniep", "susananne",
                                             "http://www.freewebhost.com/Susanspage");

        System.out.println( "First Name:        " + entry3.getFirstName() );
        System.out.println( "Middle Name:       " + entry3.getMiddleName() );
        System.out.println( "Last  Name:        " + entry3.getLastName() );
        System.out.println( "Address:           " + entry3.getHomeAddress() );
        System.out.println( "Home Phone:        " + entry3.getHomePhone() );
        System.out.println( "Cell Phone:        " + entry3.getCellPhone() );
        System.out.println( "Business Phone:    " + entry3.getBusinessPhone() );
        System.out.println( "Skype ID:          " + entry3.getSkypeId() );
        System.out.println( "Facebook ID:       " + entry3.getFacebookId() );
        System.out.println( "Personal Website:  " + entry3.getPersonalWebSite() );



      String equal =   AddressBook.compareNames(entry1.getFirstName() + " " + 
                                 entry1.getMiddleName().charAt(0) + " " + 
                                 entry1.getLastName(), 
                                 entry2.getFirstName() + " " + 
                                 entry2.getMiddleName().charAt(0) + " " + 
                                 entry2.getLastName() ); 

System.out.println(equal);


}
}