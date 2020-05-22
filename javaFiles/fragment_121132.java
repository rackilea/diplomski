PrintWriter pwInput = new PrintWriter("Undead_save.txt");
 pwInput.println(--food);   //change food-- to --food
 pwInput.println(--water);  //change water-- to --water
 pwInput.flush();           //flushing the PrintWriter
 pwInput.close();           //closing the PrintWriter
 b.combat();