interface IXYZAdapter <E extends Enum<E> & AbstractE.Flags>
{
  public Set<? extends E> getFlags();
}

class M extends AbstractE<Long, M.EF> implements IXYZAdapter<M.EF>
{
  public enum EF implements AbstractE.Flags{flag1, flag2}
  public Set<? extends M.EF> getFlags()
  {return EnumSet.allOf(EF.class);}

}