package domain;

import java.util.HashMap;
import java.util.Map;

public class AumentumDocTypeMap {
  private Map<String, String> docTypeMap;

  public AumentumDocTypeMap() {
      docTypeMap = new HashMap<String, String>();
      docTypeMap.put("7000690", "691");
  }

  public HashMap<String, String> getTypeMap() {
       return docTypeMap;
  }
}