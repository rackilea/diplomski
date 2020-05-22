@Bean
 public CamelContext contex() {
  CamelContext camelContext;
  SimpleRegistry reg = new SimpleRegistry();
  reg.put("hl7codec", new HL7MLLPCodec());
  camelContext = new DefaultCamelContext(reg);
  return camelContext;
  
 }