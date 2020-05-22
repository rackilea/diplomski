public class CStickListDeserializer extends StdDeserializer<ArrayList<Candlestick>> { 

    public CStickListDeserializer() { 
        this(null); 
    } 

    public CStickListDeserializer(Class<?> c) { 
        super(c); 
    }

    @Override
    public ArrayList<Candlestick> deserialize(JsonParser jp, DeserializationContext ctxt) 
      throws IOException, JsonProcessingException {

        Candlestick cs ;
        ArrayList<Candlestick> cList = new ArrayList<Candlestick>();
        BigDecimal[][] a = jp.readValueAs(BigDecimal[][].class);
        for(BigDecimal[] a1 : a){
            cs = new Candlestick();
            cs.setTime(a1[0].longValue());
            cs.setLow(a1[1]);
            cs.setHigh(a1[2]);
            cs.setOpen(a1[3]);
            cs.setClose(a1[4]);
            cs.setVolume(a1[5]); 
            cList.add(cs);
        }
             return cList;
    }
}