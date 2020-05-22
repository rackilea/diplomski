StringBuilder sample = new StringBuilder(); //sample refers to 
//StringBuilder at 12345 

StringBuilder referToSample = sample; //referToSample refers to 
//the same StringBuilder at 12345 
//SEE DIAGRAM 1

referToSample = null; //referToSample NOW refers to 00000, 
//so accessing it will throw a NPE. 
//The other reference is not affected.
//SEE DIAGRAM 2

sample.append("A"); //sample STILL refers to the same StringBuilder at 12345 
System.out.println(sample);