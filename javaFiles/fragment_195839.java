CsvDataFormat csv = new CsvDataFormat();
CSVConfig config = new CSVConfig();
config.setDelimiter('|'); // your delimiter here
csv.setConfig(config);

from("timer://foo?fixedRate=true&delay=0&period=2000").
to("http://graph.facebook.com/nike").unmarshal().json(JsonLibrary.Gson,Map.class)
.marshal(csv).convertBodyTo(String.class).to("file:target/output");