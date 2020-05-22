for (int n = 0; n < parts.length; n++)
        {
            for (int i = 0; i < codes.length; ++i)
            { //                ^ Fixed the loop bound here
                if (parts[n].equals(codes[i]))
                {
                    System.out.print(letters[i]);
                    break; // Quit inner loop once you find a match
                }
            }
        }
        System.out.println(); // Add a trailing newline