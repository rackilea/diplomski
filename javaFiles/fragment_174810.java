getContentPane().setLayout(new GridLayout(rows, columns));
for(int i = 0; i < rows; i++){
    for(int j = 0; j < columns; j++){
        inputFields[i][j] = new TextField("output");
        holder.add(inputFields[i][j]);
    }
}