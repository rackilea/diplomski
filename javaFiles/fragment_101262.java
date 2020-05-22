public static String strip_tags(String text, String allowedTags) {
      String[] tag_list = allowedTags.split(",");
      Arrays.sort(tag_list);

      final Pattern p = Pattern.compile("<[/!]?([^\\\\s>]*)\\\\s*[^>]*>",
              Pattern.CASE_INSENSITIVE);
      Matcher m = p.matcher(text);

      StringBuffer out = new StringBuffer();
      int lastPos = 0;
      while (m.find()) {
          String tag = m.group(1);
          // if tag not allowed: skip it
          if (Arrays.binarySearch(tag_list, tag) < 0) {
              out.append(text.substring(lastPos, m.start())).append(" ");

          } else {
              out.append(text.substring(lastPos, m.end()));
          }
          lastPos = m.end();
      }
      if (lastPos > 0) {
          out.append(text.substring(lastPos));
          return out.toString().trim();
      } else {
          return text;
      }
  }