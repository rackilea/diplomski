public static void main(String[] args) throws ParseException {
      Date d = DateUtils.parseDateStrictly("23/10/2014T12:34:22", 
          new String[] {"yyyy/MM/dd'T'HH:mm:ss",
              "dd/MM/yyyy'T'HH:mm:ss"});

      System.out.println(d);
  }