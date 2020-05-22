line = reader.readLine();

while(line != null){
    line = reader.readLine();

    if(line != null){
        fragmentShaderSource.append(line).append('\n');
    }
}