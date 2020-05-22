final long dayMilliSec=24*60*60*1000;
final long diffMilliSec=(3*60+30)*60*1000;
File file=new File(location);
long modDay=(file.lastModified()+diffMilliSec)/dayMilliSec;
long currDay=(new Date().getTime()+diffMilliSec)/dayMilliSec;
//int a=(int) Math.ceil(b);
if (currDay==modDay){
    System.exit(0);
}