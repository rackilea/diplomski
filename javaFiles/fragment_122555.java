public static void main(String[] args) throws Exception {
    DateFormat df = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    System.out.println(df.parse("Fri Aug 12 16:08:41 EDT 2011"));
}

// outputs
Fri Aug 12 15:08:41 CDT 2011