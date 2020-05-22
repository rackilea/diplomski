private final static Pattern CLIP_AMMO = Pattern.compile(".*<(\\d+)/(\\d+)>.*");

String s = "pistol . <1/10>";
Matcher m = CLIP_AMMO.matcher(s);
if (m.matches()) {
    String clip = m.group(1); //1
    String ammo = m.group(2); //10
}