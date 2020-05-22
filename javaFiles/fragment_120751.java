public class FileInCustomComparator implements Comparator<FileIn> {
   @Override
   public int compare(FileIn fileIn1, FileIn fileIn2) {
      return fileIn1.getId()-fileIn2.getId();//id consider as int here
   }
}