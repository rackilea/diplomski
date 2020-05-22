while(ReadFile.hasNextLine())
{
    String inputOfFile = ReadFile.nextLine();
    String[] info = inputOfFile.split(":");
    try{
        if(info.length == 3)
        {
            val = Integer.parseInt(info[0]);
            price = Double.parseDouble(info[1]);
            quant = Integer.parseInt(info[2]);
            stores[i].LojaValor(val);
            stores[i].LojaQuantidade(quant);
            stores[i].LojaPreco(price);
            i++;
        }
        else
        {
            System.err.println("Input incorrectly formatted: " + inputOfFile);
        }
    }catch (NumberFormatException e) {
        System.err.println("Error when trying to parse: " + inputOfFile);
    }
}