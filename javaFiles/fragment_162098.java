public class ContactsWrapper
{
   private List<BaseContact> allContacts;
   private int size;

   public List<BaseContact> getAllContacts()
   {
      return allContacts;
   }

   public void setAllContacts(List<BaseContact> allContacts)
   {
      this.allContacts = allContacts;
   }

   public int getSize()
   {
      return size;
   }

   public void setSize(int size)
   {
      this.size = size;
   }
}