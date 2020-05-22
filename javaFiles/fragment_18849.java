public static InputStream inputStream;
public static OutputStream outputStream;

@Override
public void serialEvent(SerialPortEvent evt) {
    switch (evt.getEventType()) {
        case SerialPortEvent.BI:
        //Quebra interupção.
        case SerialPortEvent.OE:
        //Erro de saturação.
        case SerialPortEvent.FE:
        //Erro de enquadramento.
        case SerialPortEvent.PE:
        //Erro de pariedade.
        case SerialPortEvent.CD:
        //Detecção de portadora.
        case SerialPortEvent.CTS:
        //Limpa para enviar.
        case SerialPortEvent.DSR:
        //Conjunto de dados prontos.
        case SerialPortEvent.RI:
        //Caminho indicado.
        case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
            /*Buffer de saída está vazio. O evento será gerado depois de uma gravação for concluída,
             quando o buffer do sistema torna-se vazia novamente..."
             */
            break;
        case SerialPortEvent.DATA_AVAILABLE:
            /*Dados disponíveis na porta serial. "
             + "Este evento será gerada uma vez quando dados novos chegam na porta de série. "
             + "Mesmo se o usuário não ler os dados, "
             + "não será gerado novamente até a próxima vez que novos dados chegam");
             */
            try {
            TimeUnit.MILLISECONDS.sleep(500); // 
        } catch (InterruptedException e) {
        }
        byte[] readBuffer = new byte[1024];
        try {
            int numBytes = 0;
            while (inputStream.available() > 0) {
                numBytes = inputStream.read(readBuffer);
            }
            String result = new String(readBuffer);
            result = result.substring(0, numBytes);
            System.out.println(result + "\n");
        } catch (IOException e) {
        }

        break;
    }
}