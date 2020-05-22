if (file.isDirectory()) {
        System.out.println("Searching directory ... "
                + file.getAbsoluteFile());
        if (file.canRead()) {
            System.out.println("Can read...");
            if (file.listFiles() == null) {
                System.out.println("yes it is null");
            } else { /* add the else */
              for (File temp : file.listFiles()) { // Problemetic line
                  if (temp.isDirectory()) {
                      search(temp);
                  } else {
                      // code to find a file
                  }
              }
            }
}