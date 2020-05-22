bool first=true;
while (((aLine = reader.readLine()) != null)) {
    if(!first)writer.newLine();
    else first=false;
    writer.write(aLine);
}