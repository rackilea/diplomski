@ManagedBean
   @ViewScoped
   public class LoginBean {

       private String mailNickname;

       public String getMailNickname() {
          return mailNickname;
       }

       public void setMailNickname(final String mailNickname) {
           this.mailNickname = mailNickname;
       }

       @ManagedProperty("#{infoBean}")
       private InfoBean infoBean;

       public void setInfoBean(final InfoBean infoBean) {
           this.infoBean = infoBean;
       }

       /** Method you use for populating */
       public void populateInput(final String mailNicknameFromDb) {
         setMailNickname(mailNicknameFromDb);
         infoBean.setMailNickname(mailNicknameFromDb);
       }
   }