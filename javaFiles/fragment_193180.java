function writeInt(stream, int){
   var bytes = new Array(4)
   bytes[0] = int >> 24
   bytes[1] = int >> 16
   bytes[2] = int >> 8
   bytes[3] = int
   stream.write(new Buffer(bytes))
}

...

writeInt(client, data.length)
client.write(data)