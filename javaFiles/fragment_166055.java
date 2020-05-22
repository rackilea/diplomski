...
@Inject RealWorkHere realImplementation;

@Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
public void myTimerMethod(){
  try{
     realImplementation.myTimerMethodImpl()
  }catch (Exception x){
   // hopefully log it somewhere
  }
}
...