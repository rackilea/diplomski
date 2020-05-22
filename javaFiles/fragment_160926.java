int emptyIndex = -1;
for(int i = 0; i < list.size(); i++){
   String text = list.get(i).getText();
   if(text.length() == 0){
       emptyIndex = i;
   }
}

if(emptyIndex == -1)
  //there is no empty text fields
else
 // the empty text field is list.get(emptyIndex)