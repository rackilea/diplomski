public static void search() {

  boolean succeeded = false;
  int attemptsLeft = MAX_ATTEMPTS;
  while (! succeeded && (--attemptsLeft > 0)) {

    try{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        System.out.println("Give me an path.");
        while ((s = in.readLine()) != null && s.length() != 0){
            SubDirs dirs = new SubDirs();
            List<File> subDirs = dirs.getSubdirs(new File(s));
            for ( File f : subDirs ) {
                System.out.println(f.getName());
            }
            System.out.println("Give me an path.");
        }

        succeeded = true;

    }catch(Exception e){
        // ALWAYS LEAVE YOURSELF A CLUE TO WHAT HAPPENED
        // e.g. the exception caught may not be the exception you expected
        e.printStackTrace();
    }

  } // while not succeeded yet

  if (! succeeded) {
    log("Hmm ... bailing search() without succeeding");
  }
}