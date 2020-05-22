public static int getClicks(String buttonName){
       for(int i = 0; i < aClass.buttonNames.length; i++){
           if(buttonName.equals(aClass.buttonNames[i])){
           return aClass.buttonClicks[i];
           }
       }
}