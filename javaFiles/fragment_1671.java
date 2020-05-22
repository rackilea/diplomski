import java.util.HashMap;
import java.util.Map;

public class ProcessConsumerFactory {

    public static enum ProcessType {

      A("processA"), B("processB");

      private String name;

      ProcessType(String name) {
        this.name = name;
      }

      public String getName() {
        return name;
      }
    }

    private class ProcessConsumer implements IProcessConsumer {

      private final ProcessType processType;
      private final ProcessDataExtractor extractor;
      private final RecordProcessor<byte[], byte[]> process;

      public ProcessConsumer(ProcessType processType, ProcessDataExtractor extractor) {
        this.processType = processType;
        this.extractor = extractor;
        this.process = new RecordProcessor<>();
      }

      @Override
      public void run() {
         // your implementation...
      }
    }

    private static ProcessConsumerFactory instance = new ProcessConsumerFactory();

    private Map<ProcessType, ProcessDataExtractor> extractorsByProcessName;

    private ProcessConsumerFactory() {
      extractorsByProcessName = new HashMap<>();
      extractorsByProcessName.put(ProcessType.A, new ProcessDataExtractorA());
      extractorsByProcessName.put(ProcessType.B, new ProcessDataExtractorB());
      // add a new element in the map to add a new mapping
    }

    public static ProcessConsumerFactory getInstance() {
      return instance;
    }

    public IProcessConsumer createNewProcessConsumer(ProcessType  processType) {
      ProcessDataExtractor extractor = extractorsByProcessName.get(processType);
      if (extractor == null) {
        throw new IllegalArgumentException("processType " + processType + " not recognized");
      }
      IProcessConsumer processConsumer = new ProcessConsumer(processType, extractor);
      return processConsumer;
    }

}