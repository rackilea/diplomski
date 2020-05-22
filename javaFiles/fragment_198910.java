import com.ximpleware.*;
    public class getContent {
        public static void main(String s[]) throws VTDException{
            VTDGen vg = new VTDGen();
            if (!vg.parseFile("C:\\Users\\HC\\Desktop\\dataset\\book.xml", false))
                return;
            VTDNav vn = vg.getNav();
            if (vn.toElement(VTDNav.FIRST_CHILD, "book")){
                long l = vn.getContentFragment();
                System.out.println( "book content ==> ");
                System.out.println(vn.toString((int)l, (int)(l<<32)));
            }
        }
    }