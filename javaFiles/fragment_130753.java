val fileContent = readFromFile(this, YOUR_FILE_NAME)
var yourInterger = if (fileContent.isEmpty()) {
    yourDefaultValue
}else{
    fileContent.toInt()
}