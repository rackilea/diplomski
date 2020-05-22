public class MyOwnTransformer implements ResultTransformer
{
 @Override//the same order in projection list properties is the same returned by data array...  
 public Dog transformTuple(Object[]data,String[]alias)
 {return new Dog((Integer)data[0],new Owner((Integer)data[1]));} 
 @Override
 public List transformList(List dogs){return dogs;}//nothing to do here....
 }