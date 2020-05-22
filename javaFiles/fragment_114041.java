String sql = "SELECT " 
        + "    SI.SITE_ID ";
Pattern p = Pattern.compile("\\b(\\w+\\.SITE_ID)");
Matcher m = p.matcher(sql);
if (m.find()) {
    System.out.println(m.group(1));
}