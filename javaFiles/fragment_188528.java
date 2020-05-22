int count = 0;
StringBuilder builder = new StringBuilder();

for(Map.Entry<String, Integer> entry:list) {
    count++;
    builder.append(count + "   " + entry.getKey()+"    "+entry.getValue());
} 

textView.setText(builder.toString());