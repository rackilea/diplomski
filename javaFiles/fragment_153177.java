String s = "T(P(p(360,72),p(480,71),p(600,75),p(720,76)" +
                ",p(840,70)),V(v(0,0),v(480,-2),v(1920,-24)" + 
                ",v(2400,-26),v(5760,-5),v(6240,-7)))";
     Pattern pattern = Pattern.compile("p\\((\\d+),(\\d+)\\)");
     Matcher matcher = pattern.matcher(s);
     while (matcher.find()) {
         logger.error(matcher.group(1));
         logger.error(matcher.group(2));
     }