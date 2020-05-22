import java.util.regex.*;
import java.text.*;

class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String VIETNAMESE_DIACRITIC_CHARACTERS 
            = "ẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ";
        /*
        for (char c: VIETNAMESE_DIACRITIC_CHARACTERS.toCharArray()) {
            System.out.println(c + ": " + Character.getName(c));
        }
        */

        String tests[] = new String[3];
        tests[0] = 
            "Bạn chính là tác giả của Wikipedia!\n" + 
            "Mọi người đều có thể biên tập bài ngay lập tức, chỉ cần nhớ vài quy tắc." +
            "Có sẵn rất nhiều trang trợ giúp như tạo bài, sửa bài hay tải ảnh." + 
            "Bạn cũng đừng ngại đặt câu hỏi.\n" +
            "Hiện chúng ta có 1.109.446 bài viết và 406.782 thành viên.";

        tests[1] =
            Normalizer.normalize(tests[0], Normalizer.Form.NFD);
        /*
        for (char c: tests[1].toCharArray()) {
            System.out.printf("%04x ", (int) c);
        }
        */  
        tests[2] =
            Normalizer.normalize(tests[0], Normalizer.Form.NFC);

        try {
            Pattern p = Pattern.compile("(?:[" + VIETNAMESE_DIACRITIC_CHARACTERS + "]|[A-Z])++", Pattern.CANON_EQ | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

            for (String t: tests) {
                Matcher m = p.matcher(t);
                while (m.find()) {
                    System.out.print(m.group() + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}