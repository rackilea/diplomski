String [] programs = {"XYZ", "TEST1", "TEST2", "TEST3", "SDFSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS"};

for(int i = 0; i < programs.length; i++) {
  System.out.println( programs[i] + " -- " + intToARGB(programs[i].hashCode()));
}
....
public static String intToARGB(int i){
    return Integer.toHexString(((i>>24)&0xFF))+
        Integer.toHexString(((i>>16)&0xFF))+
        Integer.toHexString(((i>>8)&0xFF))+
        Integer.toHexString((i&0xFF));
}