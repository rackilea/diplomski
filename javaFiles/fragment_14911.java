static String[] liquids = {"#milk;3", "#whiskey;splash"};

  public static void parseString(String input)
  {
    // Break the String down into line-by-line.
    String[] lines = input.split("" + '\n');
    for (int line_index = 0; line_index < lines.length; line_index++)
    {
      if (lines[line_index].length() > 16)
      {
        // Assume you're delimiting by '#'
        String[] tokens = lines[line_index].split("#");
        if (tokens.length > 1)
        {
          // Start at index = 1 to kill "Accept-Additions:"
          for (int token_index = 1; token_index < tokens.length; token_index++)
          {
            boolean valid = false;
            for (int liquids_index = 0; liquids_index < liquids.length; liquids_index++)
            {
              if (liquids[liquids_index].equals("#" + tokens[token_index]))
              {
                valid = true;
                // break to save some time if liquids is very long
                break;
              }
            }
            if (!valid)
            {
              throwError("#" + tokens[token_index]);
            }
          }
        }
      }
    }
  }

  public static void throwError(String error)
  {
    System.out.println(error + " is not in the Array!");
  }