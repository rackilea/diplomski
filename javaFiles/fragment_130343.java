String string2;
switch(string){
case "date":
//Give date

case "random":
//The thing is when you type "random" it will wait on the next input from the user and store it     in this variable.

while(!string2.equals("BREAK")){
    string2 = (String) inputdata.readObject();
    //It will process the users next information if the user NOT type "BREAK".
}
break;

//The problem is that the variable "string2" must be outside the while loop BUT it NEEDS in the loop. I tried with do while loop but the same problem happend.
}