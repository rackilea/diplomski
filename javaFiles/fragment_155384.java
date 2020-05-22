I write an example as per your requriment
1-we have a json array
  { 
  "status": 200,
  "status_message": "Success",
  "response":
   [ 
    {
      "quizNumber" :  "1",
        "image" : "",
        "question" : "Which car manufacturer was the first to win 100 F1 races?",
        "option1" : "Ferrari",
        "option2" : "Nissan",
        "option3" : "Ford",
        "option4" : "",
        "answer" : "Ferrari."
    },
    {
      "quizNumber" :  "2",
        "image" : "",
        "question" : "In the professional era which woman has won the most titles at Wimbledon [singles, doubles and mixed] ?",
        "option1" : "Venus",
        "option2" : "Hingis",
        "option3" : "Martina Navratilova",
        "option4" : "Waynetta",
        "answer" : "Martina Navratilova"
    },
    {
      "quizNumber" :  "3",
        "image" : "",
        "question" : "How many times have Liverpool been relegated from the top flight of English football?",
        "option1" : "Four",
        "option2" : "Three",
        "option3" : "Two",
        "option4" : "Five",
        "answer" : "Three"
    }]}   

2-Make a pojo class
class Mypojo {
  String op1,op2,op3,op4,ans;
  Mypojo(String s1,String s2,String s3,String s4,String ss){
        op1 = s1;
       .......
     ans = ss;

}
 //add getter / setter method here
}

3- Now in activity take an array list
  int i = 0;
 ArrayList<Mypojo> mypojo = new AarrayList();

where you parse json 
make pojo class object like 
Mypojo pojo = new Mypojo(parameters) and pass all parameters
then mypojo.add(pojo);
In this way all json data will be added in pojo type array list.

4-Now in Next button code will be 
int arraysize = mypojo.size();

if(i<arraysize){

  i++;
 get all values from pojo arraylist by using i as a index position like
 String op1 = mypojo.get(i).getOp1();
and change your UI.
}

This is for example if you will do all steps correctly your problem will be solved.