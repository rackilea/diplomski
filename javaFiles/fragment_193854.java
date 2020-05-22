CsvDataFormat csv = new CsvDataFormat();

from("file:/pathToFile")
.split(body().tokenize("/n")).streaming()
.unmarshal(csv)
.process(new CsvParserProcess())
.marshal(csv)
.to("file:/pathToOut").log("Finished Transformation").end();