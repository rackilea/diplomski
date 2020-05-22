String oldValue = "Pune (Maharastra)";
 Pattern pattern = Pattern.compile("\\w+");
 Matcher matcher = pattern.matcher(oldValue);
 String newValue = "";
 while (matcher.find()) {
          newValue = matcher.group();
          break;
 }