func centralManager(_: CBCentralManager, didDiscover peripheral: CBPeripheral, advertisementData: [String : Any], rssi: NSNumber){

    delegate?.didDiscoverPeripheral(peripheral)
    let splitUp : [String] = "\(advertisementData)".components(separatedBy: "\n")
    if (splitUp.count > 1)
    {
        var chop = splitUp[1]
        let counter = chop.characters.count - 2
        chop = chop[0..<counter]
        let chopSplit : [String] = "\(chop)".components(separatedBy: "\"")

        if !(chopSplit.count > 1 && chopSplit[1] == "Device Information" && !sending)
        {
            let hexString = chop[4..<7] + chop[12..<19] + chop[21..<26]
            let hexArray = [hexString[0..<1], hexString[2..<3], hexString[4..<5], hexString[6..<7], hexString[8..<9], hexString[10..<11], hexString[12..<13], hexString[14..<15], hexString[16..<17]]
            let charArray = hexArray.map { Character(hexToScalar(char: $0)) }
            let string = String(charArray) as String
            if (string == "GoTcHa" + stringify(number: writing))
            {
                writing += 1
                let messageUUID = StringToUUID(hex: String(writing) + "hello" + String(writing))
                peripheralManager.stopAdvertising()
                let name = String(writing) as NSString
                peripheralManager.startAdvertising([CBAdvertisementDataServiceUUIDsKey: [CBUUID(string: messageUUID)], CBAdvertisementDataLocalNameKey: name])
            }
        }
    }
}

func StringToUUID(hex: String) -> String
{
    var rev = String(hex.characters.reversed())
    let hexData: NSData! = rev.data(using: String.Encoding.utf8, allowLossyConversion: false) as NSData!
    rev = hexData.toHexString()
    while(rev.characters.count < 31) {
        rev = "0" + rev;
    }
    rev = String(writing % 10) + rev[0..<30]
    let finalString = rev[0..<7] + "-" + rev[8..<11] + "-" + rev[12..<15] + "-" + rev[16..<19] + "-" + rev[20..<31]
    return finalString
}