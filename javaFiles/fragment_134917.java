public interface Lotto { }

public class LottoImplSecond implements Lotto { }
public class LottoImplFirst implements Lotto { }

public class MyClass {
   public List<? extends Lotto> getLotto(Integer number){
       List<? extends Lotto> listaLotto;
       if(number==1) listaLotto=new ArrayList<LottoImplFirst>();
       else if(numeber==1) listaLotto=new ArrayList<LottoImplSecond>();
       return listaLotto;
    }
}