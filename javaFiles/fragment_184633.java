Instances data;
RemoveWithValues filter = new RemoveWithValues();

String[] options = new String[4];
options[0] = "-C";   // attribute index
options[1] = "5";    // 5
options[2] = "-S";   // match if value is smaller than
options[3] = "10";   // 10
filter.setOptions(options);

filter.setInputFormat(data);
Instances newData = Filter.useFilter(data, filter);