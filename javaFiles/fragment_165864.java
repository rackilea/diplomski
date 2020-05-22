public static class AuthorComparator implements Comparator<Author> {
   @Override
   public int compare(Author a1, Author a2) {
       return a1.getLastName().compareTo(a2.getLastName());
   }
}