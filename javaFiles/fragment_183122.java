int checksum=0;
int l= message.length();

for (int i = 0; i < l; i++) { 
checksum+= message.charAt(i);

}

String sChecksum = Integer.toString(checksum);
if(checksum>=1000){
sChecksum= sChecksum.substring(1);   

}


physicalLayer.sendFrame("("+message+":"+sChecksum+":.)");