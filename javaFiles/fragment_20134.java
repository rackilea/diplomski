func xorMessage(message: String, key: String) -> String {
    let keyChars = Array(key.utf16)
    let keyLen = keyChars.count

    let newMsg = message.utf16.enumerated().map { $1 ^ keyChars[$0 % keyLen] }
    return String(utf16CodeUnits: newMsg, count: newMsg.count)
}