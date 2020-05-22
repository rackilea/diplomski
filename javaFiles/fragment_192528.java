import Foundation

extension String {
  func UTF8toBase64() -> String {
    let data = self.dataUsingEncoding(NSUTF8StringEncoding)
    return data?.base64EncodedStringWithOptions([]) ?? ""
  }

  func Base64toUTF8() -> String {
    let data = NSData.init(base64EncodedString: self, options: []) ?? NSData()
    return String(data: data, encoding: NSUTF8StringEncoding) ?? ""
  }
}

let string = "Test"
let string64 = string.UTF8toBase64() // => "VGVzdA=="
let string2 = string64.Base64toUTF8() // => "Test