@Service
public class PetShopShoppingCartService implements ShoppingCartService{

    @Transactional(propagation=Propagation.REQUIRED)
    public void doStuff(Object obj){
        //The Pet Shop service impl uses hibernate!;
    }
}