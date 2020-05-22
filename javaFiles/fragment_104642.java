String[] houseOfStark = {"Eddard", "Catelyn", 
                       "Robb", "Sansa", "Arya", "Bran", "Rickon"}; // Sorry Jon
String[] copyOfStark  = houseOfStark;
String[] cloneOfStark = houseOfStark.clone();

houseOfStark[1] = "Lady Catelyn";

System.out.println(houseOfStark[1]);
System.out.println(copyOfStark[1]);
System.out.println(cloneOfStark[1]);