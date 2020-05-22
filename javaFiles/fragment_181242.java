JSONArray taxes= new JSONArray();
JSONArray vat = new JSONArray();
JSONObject a = new JSONObject();
a.put("TaxRate", "A");
a.put("Amount", 100);
vat.add(a);

JSONObject b = new JSONObject();
b.put("TaxRate", "B");
b.put("Amount", 300);
vat.add(b);

JSONObject vatObject = new JSONObject();
vatObject.put("VAT", vat);
taxes.add(vatObject);

JSONObject taxesObject = new JSONObject();
taxesObject.put("Taxes", taxes);

// generate string:
System.out.println(taxesObject.toJSONString());

// or create JWT:
new JWSObject(new JWSHeader(...), new Payload(taxesObject))