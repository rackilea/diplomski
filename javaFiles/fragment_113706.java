StringBuilder myBuilder = new StringBuilder();

myBuilder.append("myVariable<-c(");

for (Double dble:myArray) {
    myBuilder.append(dble.toString());
    myBuilder.append(",");
}

myBuilder.deleteCharAt(myBuilder.length()-1);

myBuilder.append(")");

engine.eval(myBuilder.toString());