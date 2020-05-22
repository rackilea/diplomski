final String startToken = ",INDEX,PREVIOUS CLOSE,OPEN,HIGH,LOW,CLOSE,GAIN/LOSS";
final String endToken = ",ADVANCES,533";    

final PipedWriter pipedWriter = new PipedWriter();     
PipedReader pipedReaderTmp = null;
try {
    pipedReaderTmp = new PipedReader(pipedWriter);
} catch (IOException e) {
    // do something smart
}
final PipedReader pipedReader = pipedReaderTmp;

// Consumer    
new Thread(new Runnable() {        
    @Override
    public void run() {
        try (CSVReader csvReader = new CSVReader(pipedReader)) {            
            while (true) {                        
                String[] line = csvReader.readNext(); // blocks until the next line is available
                if (line == null) break; // end of stream has been reached
                //
                // Nonsense output routine follows; replace with your own logic
                //
                for (String component : line) {
                    System.out.print(component + '\t');
                }
                System.out.println();
             }            
        } catch (IOException e) {
            // do something smart
        }        
    }
}).start();

// Producer
new Thread(new Runnable() {        
    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader("filename"))) {                        
            String line = null;

            // consume everything up to and including the start token
            while ((line = br.readLine()) != null) {
                if (startToken.equals(line)) break;
            }

            // consume everything up to and including the end token
            while ((line = br.readLine()) != null) {
                if (endToken.equals(line)) break;
                pipedWriter.write(line + '\n');            
            }
            pipedWriter.close();            
        }
        catch (IOException e) {
            // do something smart
        }        
    }
}).start();