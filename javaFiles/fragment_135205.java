public static class Data
{
  String buttonText = "";
  String buttonPassword = ""; 
  String buttonAction = ""; 
  String buttonFont = "";
  int buttonPosX = 0;
  ...
}

...
private Data data = new Data();
...
parent.addButton(data);
...