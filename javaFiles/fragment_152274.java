// remember to add these at the top:
import java.util.regex.Matcher;
import java.util.regex.Pattern;



String pattern = "ATGCN";
String nucleotides = "ATGATGAATGCC";

// first convert the pattern into a proper regex
// i.e. replacing any N with [ATCG]
Pattern regex = Pattern.compile(pattern.replaceAll("N", "[ATCG]"));

// create a Matcher to find everywhere that the pattern matches
Matcher m = regex.matcher(nucleotides);

// find all the matches
while (m.find()) {
    System.out.println("Match found:");
    System.out.println("start:" + m.start());
    System.out.println("end:" + (m.end() - 1)); // minus 1 here because the end of a regex match is always off by 1
    System.out.println();
}