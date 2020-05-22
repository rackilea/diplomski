import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "(.+?)([0-9]+)\\s\\[m.+";
final String string = "2019 May 22 03:32:17.952296 france1v4 sh[4937]: 190522-03:32:17.951792 [mod=REC, lvl=INFO] [tid=26130] Recording A8602096210405800406L200218680503121519 size is 4145956224 bytes\n"
     + "2019 May 22 03:32:17.952387 france1v4 sh[4937]: 190522-03:32:17.951895 [mod=REC, lvl=INFO] [tid=26130] RecordingInfo = fffocap://0x401e\n"
     + "2019 May 22 03:32:17.952466 france1v4 sh[4937]: 190522-03:32:17.951934 [mod=REC, lvl=INFO] [tid=26130] recording_dvr_from_recording_info:physicalSegmentCount=10   \n";
final String subst = "\\2";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

// The substituted value will be contained in the result variable
final String result = matcher.replaceAll(subst);

System.out.println("Substitution result: " + result);