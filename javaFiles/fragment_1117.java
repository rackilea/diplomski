float sum = 0 ;
while (scanner.hasNextLine()) { 
     String line = scanner.nextLine();
     String [] words = line.split("\t"); 
     names[l] = words[0]; 
     scores[l] = Integer.parseInt(words[1]);
     sum+=scores[l];
     System.out.println(" name: " + names[l] + ", score: " + scores[l]);
     l++; 
}
System.out.println(sum/l);