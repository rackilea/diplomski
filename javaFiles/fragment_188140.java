import java.util.UUID;
class A
{
    public static void main(String[] args){


        String input = "f9e113324bd449809b98b0925eac3141";                         
        String uuid_parse = input.replaceAll(                                            
                        "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})",                            
                        "$1-$2-$3-$4-$5");                                                      

        UUID uuid = UUID.fromString(uuid_parse);
        System.out.println(uuid);
    }
}