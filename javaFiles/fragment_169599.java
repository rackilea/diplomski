listIps:class RProperties{  
   attProperties:{  
      PRASANTA3=class AttProperty{  
         Ip:192.168.57.39;
         Agent:PRASANTA1 ;
         dstId:PRASANTA2
      }
   }
}

The above code should be like below format,

listIps:class RProperties extends HashMap<String,AttProperty>{       
      "PRASANTA3"=class AttProperty{  
         Ip:192.168.57.39;
         Agent:PRASANTA1 ;
         dstId:PRASANTA2
      }
}


Here RProperties class should extends from Hashmap , instead of RProperties contains one more class (AttProperties) which again contains the hashmap properties.

Here RProperties is a HashMap which contains key("PRASANTA3"),value(AttProperty class values) .