Bundle asd = getIntent().getExtras();
switch(asd.getInt("button id", -1)){
case button_1:
    [put here the code you want to execute if button1 was pressed]
case button_2:
     [put here the code you want to execute if button2 was pressed]
case no_button:
     [put here the code you want to execute if something else happened]
}