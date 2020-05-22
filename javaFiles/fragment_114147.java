private double[] data;  

//As you throw a exception inside your method (constructor in this case)
//you need to declare the 'throws Exception' clause, so you have to 
//catch this exception when you create a new instance of DataSet.
public DataSet(double[] _data) throws Exception
{  
   //Your comment says 'the number of data points must be at least 2'
   //you accomplish this by checking its size.
   if(_data.length < 2) {
       //As it say exception I assume in this case you want to throw a exception
       //you accomplish this like the following           
       throw new Exception("the number of data points must be at least 2");
   }
   //"Save the parameter into the instance variable"
   //It's pretty clear to me what "t0mppa" said. Read again please...
   this.data = _data;
}