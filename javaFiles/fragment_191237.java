StringBuilder  csvSkills = new StringBuilder();
for (String s:  request.getParameterValues("chkSkills")){
    if (csvSkills.length > 0) csvSkills.append(",");
    csvSkills.append(s);
}
return csvSkills.toString();