private static void builddataTables(List<LocalDate> dateList) {
    dateList.forEach(date -> {
        message.append("<a name=\"")
        .append(date.toEpochDay())
        .append("\" id=\"")
        .append(date.toEpochDay())
        .append("\"><table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width:500px;background-color: #cedbf3;border: 1px solid rgba(19, 14, 14, 0.56);padding:15px;\"><tr><td colspan=\"2\" style=\"background-color: #5ab4ff;color:#ffffff;line-height:100%;font-family:Helvetica,Arial,sans-serif;font-size:20px;font-weight:400;margin-bottom:5px;text-align:center;\">")
        .append(date.format(DateTimeFormatter.ofPattern("cccc, dd MMMM yyyy")))
        .append("</td></tr><tr><td style=\"width:30%;\">Key Dat1</td><td style=\"width:70%;\">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ac mi eu lorem sagittis lacinia vel ac metus</td></tr><tr><td>Key Data2</td><td>Cras lobortis consectetur mi a porttitor. Vestibulum blandit urna et elit sollicitudin</td></tr></table></a>");
    });
}