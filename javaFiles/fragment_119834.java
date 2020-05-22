AsyncXMLInputFactory inputF = new InputFactoryImpl();

//Parse part 1
byte[] input_part1 = "<root>val".getBytes("UTF-8");
AsyncXMLStreamReader<AsyncByteArrayFeeder> parser = inputF.createAsyncFor(input_part1);

//Process events here

//Parse part 2
byte[] input_part2 = "ue</root>".getBytes("UTF-8");
parser.getInputFeeder().feedInput(input_part2);

//Process more events here