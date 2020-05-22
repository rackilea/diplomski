init(data:NSData) {
    self.data = data
}

func next() -> UInt8? {
    guard !self.atEnd else { return nil }
    let byte = self.data.subdata(with: NSRange(location: self.index, length: 1))[0]
    self.index += 1
    return byte
}

func next(_ count:Int) -> NSData? {
    guard self.index + count <= self.data.length else { return nil }
    let subdata = self.data.subdata(with: NSRange(location: self.index, length: count))
    self.index += count
    return subdata as NSData?
}

func upTo(_ marker:UInt8) -> NSData? {
    if let end = (self.index..<self.data.length).index( where: { self.data.base64EncodedData()[$0] == marker } ) {
        let upTo = self.next(end - self.index)
        self.skip() // consume the marker
        return upTo
    }
    else {
        return nil
    }
}

func skip(_ count:Int = 1) {
    self.index += count
}

func skipThrough(_ marker:UInt8) {
    if let end = (self.index..<self.data.length).index( where: { self.data.base64EncodedData()[$0] == marker } ) {
        self.index = end + 1
    }
    else {
        self.index = self.data.length
    }
}