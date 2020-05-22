String str = "EC: 132/194 => 68% SC: 55/58 => 94% L: 625";

Pattern p = Pattern.compile("^EC: ([0-9]+)/([0-9]+).*$");
Matcher m = p.matcher(str);

if (m.matches())
{
    String firstValue = m.group(1); // 132
    String secondValue= m.group(2); // 194
}