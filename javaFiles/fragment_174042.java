double s1 = 0.0;
      try {
           s1 = Double.parseDouble(str);
     } catch(NumberFormatException e) {}
        NumberFormat nf2 = NumberFormat.getInstance(Locale.ENGLISH);
        ((DecimalFormat)nf2).applyPattern("$ ###,###.###");
         s.replace(0, s.length(), nf2.format(s1));

         isEdiging = false;