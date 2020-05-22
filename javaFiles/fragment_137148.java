@Override
public void run() {
    String responseLine;
    try {
        while(!isInterrupted()) 
        while ((responseLine = in.readLine()) != null) {
            System.out.println(responseLine);

            if (responseLine.contains("Bye")) break;
        }
    } catch (IOException e) {
            System.err.println("Erro ao receber mensagem do servidor: " + e.getMessage());
    }
}