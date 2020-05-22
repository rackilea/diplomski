p = new ProcessBuilder("plutil",
                       "-convert",
                       "json",
                       "-o",
                       "-",
                       "/Users/chris/project/temp tutoral/project.plist")
       .start();