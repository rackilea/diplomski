String s1="01:IF   rd.h && dq.L && o.LL && v.L THEN la.VHB , av.VHR with 0.4610;";
Matcher m = Pattern.compile("(?:\\d{2,3}?(?::IF))?[\\s,&]+(?:with)?|(\\S+)").matcher(s1);
while(m.find())
{
    if(m.group(1) != null)
    System.out.println(m.group(1));
}