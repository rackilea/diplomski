...
 else if(nine==event.getSource()){
     digit = 9;
 } else if(zero==event.getSource()){
     digit = 0;
 }
...
num = num * 10 + digit;
...
result.setText(Long.toString(num));