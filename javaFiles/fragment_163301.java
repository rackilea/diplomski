import java.text.Normalizer;

public static String stripAccents(String s) 
{
    s = Normalizer.normalize(s, Normalizer.Form.NFD);
    s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    return s;
}