public class j {

    static String sss = "male,O+,45,saudi,brain_diseases";
    static int size = sss.length();

    //I suggest you not to give them a start value or set them as null
    static String male = "";
    static String blood = "";
    static String age = "";
    static String nat = "";
    static String dis = "";

    static void func() {

        //it uses the "," character to breaks the string sss into pieces
        //so became into "male","O+","45","saudi","brain_diseases"
        String[] pieces = sss.split(",");

        //pieces[0] is the first piece so = "male"
        //pieces[1] is the second "O+" and so on
        male = pieces[0];
        blood = pieces[1];
        age = pieces[2];
        nat = pieces[3];
        dis = pieces[4];

        System.out.println(male);
        System.out.println(blood);
        System.out.println(age);
        System.out.println(nat);
        System.out.println(dis);

    }

    public static void main(String[] args) {

        func();        
    }
}