func md5(string string: String) -> NSData {
    var digest = [UInt8](count: Int(CC_MD5_DIGEST_LENGTH), repeatedValue: 0)
    let data = string.dataUsingEncoding(NSUTF8StringEncoding)! // Conversion to UTF-8 cannot fail
    CC_MD5(data.bytes, CC_LONG(data.length), &digest)
    return NSData(bytes: digest, length: digest.count)
}