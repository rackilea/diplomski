StringBuilder sb_rules = new StringBuilder();
StringBuilder sb_content = new StringBuilder();
while ((readLine = br.readLine()) != null)
{
    sb_rules.append(readLine);
    sb_rules.append(eol);
    if (previousLine.equals(""))
    {
        sb_content.append(readLine);
        sb_content.append(eol);
    }
    previousLine = readLine;
}
content = sb_rules.toString();
content = sb_content.toString();