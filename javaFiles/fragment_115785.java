import CryptoSwift

func decrypt(input:String)->String?{
        let key = "1234512345123456"
        do{
            let d=Data(base64Encoded: input)
            let decrypted = try AES(key: key, iv: key, padding: .pkcs5).decrypt(
                d!.bytes)
            return String(data: Data(decrypted), encoding: .utf8)
        }catch{

        }
        return nil
    }