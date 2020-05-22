dataHex = data.encodeHex().toString()
log.info "data hex in bytes = ${dataHex}"

// group data by bytes
def dataHexBy2 = dataHex.toList().collate(2)*.join()
log.info " group by 2 " + dataHexBy2

def address = ""

for (i=22;i<25;i++)
{
    address = address + dataHexBy2[i]
} 
log.info "address = ${address}"