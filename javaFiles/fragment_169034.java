func AES_EncryptionKey() -> String {
    let date = NSDate()
    let calender = NSCalendar.currentCalendar()
    let components = calender.components([.Day,.Month,.Year], fromDate: NSDate())
    let year = components.year
    var day = String(components.day)
    var month = String(components.month)
    if day.characters.count == 1 {
        day = "0\(String(day))"
    }
    if month.characters.count == 1 {
        month = "0\(String(month))"
    }
    //Mark: Please change the key as per your requirment! I am using a dynamic key now  rather the one specified in question . i.e It changes everday
    let secretKey = "\(String(day))20\(month)u\(String(year))e"
    return secretKey

}


func AESencrypt() throws -> String  {

    //Mark: You have to do the same thing in Android too. If u skip this here skip in android too
    let secretKeyTest = AES_EncryptionKey().toBase64()!



    let inputBytes: [UInt8] = Array(self.utf8)
    let key:        [UInt8] = Array(secretKeyTest.utf8) //16
    let iv:         [UInt8] = Array("0000000000000000".utf8)  //16

    var encryptedBase64 = ""
    do
    {
        let encrypted: [UInt8] = try AES(key: key, iv: iv, blockMode: .ECB).encrypt(inputBytes)
        let encryptedNSData = NSData(bytes: encrypted, length: encrypted.count)
        encryptedBase64 = encryptedNSData.base64EncodedStringWithOptions([])

        //Mark: You have to do the same thing in Android too. If u skip this here skip in android too
        encryptedBase64=encryptedBase64.toBase64()!

        //Mark: Follow the same blockMode in both platform. ECB Mode is not recommended. I did it in ECB cuz it was already done in other platform
        let decrypted: [UInt8] = try AES(key: key, iv: iv, blockMode: .ECB).decrypt(encrypted)
        let result = String(bytes: decrypted, encoding: NSUTF8StringEncoding)!
        print("result\t\(result )")
    }
    catch
    {
        print("FAIL ENCRYPT")
    }
    print("encryptedBase64: \(encryptedBase64)")

    return encryptedBase64

}

func AESdecrypt() throws -> String {
    var decryptedString = "NIL"
    let secretKeyTest = AES_EncryptionKey().toBase64()!

    let key:        [UInt8] = Array(secretKeyTest.utf8) //16
    let iv:         [UInt8] = Array("0000000000000000".utf8)  //16

    //Step1
    let encryptedData = self.dataUsingEncoding(NSUTF8StringEncoding)!
    if let base64Decoded_ = NSData(base64EncodedData: encryptedData, options:  NSDataBase64DecodingOptions.IgnoreUnknownCharacters)
    {

        if var stringBase64 = String(data:base64Decoded_, encoding: NSUTF8StringEncoding)
        {
            //Step2
            let encryptedDataSecond = stringBase64.dataUsingEncoding(NSUTF8StringEncoding)!
            let base64DecodedSecond_ = NSData(base64EncodedData: encryptedDataSecond, options:  NSDataBase64DecodingOptions.IgnoreUnknownCharacters)
            //Step3
            let encrypted = Array(UnsafeBufferPointer(start: UnsafePointer<UInt8>(base64DecodedSecond_!.bytes), count: base64DecodedSecond_!.length))
            do
            {
                let decryptedData = try AES(key: key, iv: iv, blockMode: .ECB).decrypt(encrypted)
                decryptedString = String(bytes: decryptedData, encoding: NSUTF8StringEncoding)!
                print("decryptedString: \(decryptedString)")
                print("ALL DECRYPTED")

            }
            catch
            {
                print("FAIL DECRYPT")
            }
        }
    }


    return decryptedString


}



func fromBase64() -> String? {
    guard let data = NSData(base64EncodedString: self, options: NSDataBase64DecodingOptions(rawValue: 0)) else {
        return nil
    }

    return String(data: data, encoding: NSUTF8StringEncoding)
}

func toBase64() -> String? {
    guard let data = self.dataUsingEncoding(NSUTF8StringEncoding) else {
        return nil
    }

    return data.base64EncodedStringWithOptions(NSDataBase64EncodingOptions(rawValue: 0))
}}