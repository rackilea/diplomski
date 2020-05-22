public static void main(String[] args) {
          Calendar ten_year_later = Calendar.getInstance();
          System.out.println( ten_year_later.getTime() );
          ten_year_later.setTime(new Date()); 
          ten_year_later.add(Calendar.YEAR, 10);
          System.out.println( ten_year_later.getTime() );
          Calendar expiration = Calendar.getInstance(); 
          expiration.setTime(expiration.getTime()); 
          long max = (ten_year_later.getTimeInMillis() - expiration.getTimeInMillis())/(365 * 24 * 60 * 60 * 1000L); 
          System.out.println( "max " + max );
        }