String dayNames[] = {"S", "M", "Tu", "W", "Th", "F", "S"};
result.append("<html><font face='Arial'>");
result.append("<table>");
result.append("<tr>");
for (String dayName : dayNames) {
    result.append("<td align='right'>").append(dayName).append("</td>");
}
result.append("</tr>");
result.append("<tr>");
for (int i = 0; i < d; i++) {
    result.append("<td></td>");
}
for (int i = 0; i < numOfDays[month]; i++) {
    if (((i + d) % 7 == 0)) {
        result.append("</tr><tr>");
    }
    result.append("<td align='right'>").append(i + 1).append("</td>");
}
result.append("</tr>");
result.append("</table>");

result.append("</html>");