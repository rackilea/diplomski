String name = JOptionPane.showInputDialog("Hi! How are you? My name is Chatbot! What is yours? ");
String city="";
if (name.compareTo("a")<0){
    city = JOptionPane.showInputDialog("Nice to meet you! Where are you from, "+name);
}
else
    {
    city = JOptionPane.showInputDialog("Huh. That's a strange name. Where are you from,"+name);  
     }