// Removes the 4-letter words from c
    static void expurgate(Collection<String> c) {
        for (Iterator<String> i = c.iterator(); i.hasNext(); )
          if (i.next().length() == 4)
            i.remove();

}