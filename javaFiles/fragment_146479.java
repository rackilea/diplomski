StringBuilder sb = new StringBuilder();
for(House h: houses)
{
    sb.append(String.format("We're insanely proud to present you house nr %d at %s road\r\n", h.houseNumber, h.road));
}
String ad = sb.toString();