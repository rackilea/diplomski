function byteToUint8Array(byteArray) {
    var uint8Array = new Uint8Array(byteArray.length);
    for(var i = 0; i < uint8Array.length; i++) {
        uint8Array[i] = byteArray[i];
    }

    return uint8Array;
}