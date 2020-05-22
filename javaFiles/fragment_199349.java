[Embed(source="myKeyFile.key", mimeType="application/octet-stream")]
private const _KeyFile:Class;
private var keyFile:ByteArray = new _KeyFile();

...

trace(keyFile.length + " bytes"); // XYZ bytes