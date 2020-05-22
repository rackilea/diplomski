public class OptionT<A> {
   @Getter
   final AnyM<Optional<A>> run;

   public OptionT(final AnyM<Optional<A>> run){
       this.run = run;
   }

   public <B> OptionT<B> map(Function<A,B> f){
       return new OptionT<B>(run.map(o-> o.map(f)));
   }


}

@Test
public void test() {
    OptionT<Integer> optionT = new OptionT<>(AnyM.ofMonad(Stream.of(Optional.of(10))));
    System.out.println(optionT.map(num->"hello world"+num).getRun().asSequence().firstValue());
}