Pattern.compile(
      Pattern.quote("\\begin{theorem}")
        + "("
            + "(.+?)"
            + Pattern.quote("\\begin{theorem}")
                + "(.+?)"
            + Pattern.quote("\\end{theorem}")
        + ")*"
     + Pattern.quote("\\end{theorem}"));