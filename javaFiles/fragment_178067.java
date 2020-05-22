@ManagedBean
@SessionScoped
public class PessoaFisicaBean {

   HumanDaoImp dao = new HumanDaoImp();

   public void add() {
       Human human = new Human();//New object
       dao.add(human);      
   } 

   public void edit() {
       Human human = getHuman();//Old object that want to edit
       dao.edit(human);      
   }    

}