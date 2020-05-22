@async 
void pause() // triggered by parallel running app when required
{
   isFlagChecked=true;
   resumeTime=new Date(timeInMillis + (someDefinedTime)) // resume time to switch flag condition
   while (true) {
      if (new Date().compareTo(resumeTime) > 0) 
         isFlagChecked=false;
    }
}