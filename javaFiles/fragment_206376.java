//Create delta
String[] deltaArgs = new String[]{fileAJson.getAbsolutePath(), fileBJson.getAbsolutePath(), fileDelta.getAbsolutePath()};
XDeltaEncoder.main(deltaArgs);

//Apply delta
deltaArgs = new String[]{"-d", fileAJson.getAbsolutePath(), fileDelta.getAbsolutePath(), fileBTarget.getAbsolutePath()};
XDeltaEncoder.main(deltaArgs);

//Trivia, Surpisingly this also works
deltaArgs = new String[]{"-d", fileBJson.getAbsolutePath(), fileDelta.getAbsolutePath(), fileBTarget.getAbsolutePath()};
XDeltaEncoder.main(deltaArgs);