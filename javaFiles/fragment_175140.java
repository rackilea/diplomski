String[] headercol = {"Type","Asc","Ref","Commandes","Prix unitaire","Prix total"};
String[][] content = {{"A","B","C","D","E","F","G","H"}, {"1","2","3","4","5","6","7","8"}};
String[] footer = {"a","b","c","d","e","f","g","h"};

String[][] global = (String[][]) concatenate (wrap(headercol),content);
global = (String[][]) concatenate (global, wrap(footer));

for (String[] row : global) {
    System.out.println(Arrays.toString(row));
}