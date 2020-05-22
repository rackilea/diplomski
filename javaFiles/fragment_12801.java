map(heap.objects('java.lang.StringBuffer'),
 function(it, index) {
  var writer = new java.io.FileWriter("c:/temp/oql/stringbuffer_0x" + it.id.toString(16) + ".txt");
  var chars = it.value;
  for (var i=0; i<chars.length; i++) {
   writer.write(chars[i]);
  }
  writer.close();
})