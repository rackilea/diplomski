// Removes 4-letter words from c. Elements must be strings
    static void expurgate(Collection c) {
        for (Iterator i = c.iterator(); i.hasNext(); )
          if (((String) i.next()).length() == 4)
            i.remove();

}